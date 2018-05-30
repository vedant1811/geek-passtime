// www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

class Main {
  public static int search(int[] a, int n) {
    int pivot = getPivot(a, 0, a.length - 1);
    int left = binarySearch(a, n, 0, pivot);
    if (left == -1) {
      return binarySearch(a, n, pivot + 1, a.length - 1);
    } else {
      return left;
    }
  }

  private static int binarySearch(int[] a, int n, int start, int end) {
    if (start > end || n < a[start] || n > a[end]) return -1;

    int mid = (start + end) / 2;

    if (a[mid] == n) return mid;

    if (n < a[mid - 1])
      return binarySearch(a, n, start, mid - 1);
    else
      return binarySearch(a, n, mid + 1, end);
  }

  private static int getPivot(int[] a, int start, int end) {
    if (a[start] < a[end]) return a.length-1;

    if (start == end - 1) return start;

    int mid = (start + end) / 2;
    return Math.min(getPivot(a, start, mid), getPivot(a, mid, end));
  }

  public static void main(String[] args) {
    int[] a = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    System.out.println(search(a, 10));
  }
}
