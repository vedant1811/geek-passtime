// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/

class Main {
  public static int rotationCount(int a[]) {
    if (a == null || a.length <= 1) return 0;

    return rotationCount(a, 0, a.length - 1);
  }

  private static int rotationCount(int a[], int start, int end) {
    if (start == end) return start;

    // now we have atleast 2 elements in range

    int mid = (start + end) / 2;

    if (isMin(a, mid)) return mid;

    if (a[mid] > a[mid + 1]) return rotationCount(a, mid + 1, end);

    if (mid == start) return start;

    return rotationCount(a, start, mid - 1);
  }

  private static boolean isMin(int a[], int i) {
    if (i == 0 && a[0] < a[1]) return true;
    if (i == a.length - 1 && a[a.length - 1] < a[a.length - 2]) return true;

    return a[i] < a[i-1] && a[i] < a[i+1];
  }

  public static void main(String[] args) {
    System.out.println(rotationCount(new int[] {15, 18, 2, 3, 6, 12}));
  }
}
