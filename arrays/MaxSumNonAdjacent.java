// https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
// Additionally, handle negative numbers

class Main {
  public static int maxSum(int a[]) {
    if (a == null || a.length == 0) return 0;

    int l = 0, r = 0;

    for (int i = 0; i < a.length; i++) {
      if (a[i] <= 0) {
        r = Math.max(l,r);
        l = r;
        continue;
      }
      if (i % 2 == 0) {
        // left
        l += a[i];
      } else {
        // right
        r += a[i];
        r = Math.max(l, r);
      }
    }
    return Math.max(l, r);
  }

  public static void main(String[] args) {
    System.out.println(maxSum(new int[] {3, 2, 7, 10}));
  }
}
