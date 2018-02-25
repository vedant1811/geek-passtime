// www.geeksforgeeks.org/median-of-two-sorted-arrays

// in O(log n)
class Main {
  private static int[] a1;
  private static int[] a2;
  private static int n;
  public static int median(int[] a1, int[] a2, int n) {
    Main.a1 = a1;
    Main.a2 = a2;
    Main.n = n;

    return median(0, n - 1, 0, n - 1);
  }

  private static int median(int l1, int r1, int l2, int r2) {
    int m1 = (l1 + r1) / 2;
    int m2 = (l2 + r2) / 2;

    if (a1[m1] == a2[m2]) return a1[m1];

    if (r1 - l1 == 1) {
      return (Math.max(a1[l1], a2[l2]) + Math.min(a1[r1], a2[r2])) / 2;
    }

    if (a1[m1] < a2[m2]) {
      return median(m1, r1, l2, m2);
    } else {
      return median(l1, m1, m2, r2);
    }
  }

  public static void main(String[] args) {
    int[] a1 = {1, 12, 15, 26, 38};
    int[] a2 = {2, 13, 17, 30, 45};

    System.out.println(median(a1, a2, a1.length));
  }
}
