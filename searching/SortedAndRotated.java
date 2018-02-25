// www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

class Main {
  public static int search(int[] a, int n, int start, int end) {
    if (start > end) return -1;

    int mid = (start + end) / 2;

    if (a[mid] == n) return mid;

    if (a[start] > a[end]) {
      int left = search(a, n, start, mid - 1);
      if (left == -1)
        return search(a, n, mid + 1, end);
      else
        return left;
    } else if (a[start] <= n && n <= a[end]) {
      if (n < a[mid - 1])
        return search(a, n, start, mid - 1);
      else
        return search(a, n, mid + 1, end);
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    System.out.println(search(a, 3, 0, a.length - 1));
  }
}
