// provies get and put methods
class LruCache<T> extends LinkedHashMap<Uri, T> {
  int mMaxSize;

  LruCache(int maxSize) {
    super(16, 0.75, true) // initialize with default load factor and capacity with access order ordering mode
    mMaxSize = maxSize;
  }

  @Override
  boolean removeEldestEntry(Map.Entry eldest) {
    return size() > mMaxSize;
  }
}

class BitmapCache extends LruCache<Bitmap> {

  @Override
  Bitmap get(Uri path, BitmapOptions options) {
    // other optimizations like reusing existing different bitmaps can be implements in the future
    return super(createUri(path, options));
  }

  @Override
  void put(Uri, BitmapOptions options, Bitmap bitmap) {
    super(createUri(path, options), bitmap);
  }

  // create a unique uri from 'path' and 'options'
  private static Uri createUri(Uri path, BitmapOptions options) {
    // ...
  }
}

class DiskCache {
  MAX_SIZE = 10 * 1024 * 1024; // 10 MB
  File baseDirectory;
  DbTable filesTable; // ORM to table with columns 'String path', 'DateTime last_accessed_at', 'Integer size'

  DiskCache() {
    baseDirectory = new File('cache');
    filesTable = Orm.loadTable('files');
  }

  byte[] get(Uri uri) {
    Entry entry = filesTable.getFromPath(uri.toString());
    entry.updateLastAccessedAt(Time.now());
    return entry.file();
  }

  void put(Uri uri, byte[] data) {
    File file = createFile(data, baseDirectory.path() + "/" + uri.toString()); // create a file in 'cache/uri'
    filesTable.create(uri.toString(), Time.now(), file.length());
    if (filesTable.totalSize() > MAX_SIZE) {
      trimCache();
    }
  }

  private void trimCache() {
    runAsync(() -> {
      while(filesTable.totalSize() > MAX_SIZE) {
        Entry entry = filesTable.lastFile(); // get the entry with oldest last_accessed_at
        entry.file().delete();
        entry.destroy();
      }
    });
  }
}

class ImageCache {
  // the cache max sizes (10, 50, 10 MB) should be changed based on the device
  BITMAP_CACHE_SIZE = 10;
  ENCODED_DATA_CACHE_SIZE = 50;

  BitmapCache bitmapCache;
  LruCache<EncodedData> encodedDataCache; // EncodedData is a wrapper around byte[] and BitmapOptions
  DiskCache diskCache;

  ImageCache() {
    bitmapCache = new BitmapCache(BITMAP_CACHE_SIZE);
    encodedDataCache = new LruCache<>(ENCODED_DATA_CACHE_SIZE);
    diskCache = new DiskCache();
  }

  /**
   * Fetches a bitmap checking each of the following in order:
   * 1. In Memory Bitmap cache
   * 2. In Memory Encoded Data cache
   * 3. Disk cache
   * 4. Network Api
   *
   * Note: Could be long running
   * @param uri A unique identifier for the image
   */
  Bitmap fetchBitmap(Uri uri, BitmapOptions options) {
    Bitmap bitmap = bitmapCache.get(uri, options);
    if (bitmap != null) {
      return bitmap;
    }

    byte[] data;
    EncodedData encodedData = encodedDataCache.get(uri);
    if (encodedData != null) {
      data = encodedData.getByteArray();
      return createAndStoreBitmap(uri, data, options);
    }

    data = diskCache.get(uri);
    if (data == null) { // if data is not on disk then fetch from api and store it in disk
      data = fetchFromApi(uri);
      diskCache.put(uri, data);
    }
    createAndStoreEncodedData(uri, data, options);
    return createAndStoreBitmap(uri, data, options);
  }

  // call this when the activity is paused
  // clears the bitmapCache
  void onPause() {
    bitmapCache.clear();
  }

  // call this when the activity is resumed
  // loads the bitmapCache
  void onResume() {
    runAsync(() -> {
      Iterator i = encodedDataCache.iterator();
      while(i.hasNext() && bitmapCache.size() < BITMAP_CACHE_SIZE) {
        Entry entry = i.next();
        EncodedData encodedData = entry.value()
        createAndStoreBitmap(entry.key(), encodedData.getByteArray(), encodedData.getOptions());
      }
    })
  }

  private Bitmap createAndStoreBitmap(Uri uri, byte[] data, BitmapOptions options) {
    Bitmap bitmap = BitmapFactory.crateBitmap(data, options);
    bitmapCache.put(uri, options, bitmap);
    return bitmap;
  }

  private void createAndStoreEncodedData(Uri uri, byte[] data, BitmapOptions options) {
    EncodedData encodedData = new EncodedData(data, options);
    encodedDataCache.put(uri, encodedData);
  }
}
