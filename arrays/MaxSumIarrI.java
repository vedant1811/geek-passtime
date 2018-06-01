// https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/

// probably incorrect
class Main {
  public static int maxSumIarrI(int a[]) {
    if (a == null || a.length == 0) return 0;

    int maxI = 0, minI = 0, max = a[0], min = a[0];

    for (int i = 1; i < a.length; i++) {
      if (a[i] >= max) {
        maxI = i;
        max = a[i];
      }
      if (a[i] < min) {
        minI = i;
        min = a[i];
      }
    }

    int sum1 = sumFromI(a, minI);
    int sum2 = sumFromI(a, (maxI + 1) % a.length);

    return Math.max(sum1, sum2);
  }

  private static int sumFromI(int a[], int startI) {
    int n = a.length;

    int sum = 0;
    for (int i = 1; i < n; i++) {
      sum += i * a[(startI + i) % n];
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(maxSumIarrI(new int[] {10, 0, 0, 10}));
  }
}
