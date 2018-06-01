// https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/

class Main {
  public static int maxSumIarrI(int a[]) {
    if (a == null || a.length == 0) return 0;

    int sum = 0, s0 = 0;

    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      s0 += i * a[i];
    }

    int sMax = s0, sLast = s0;

    for (int i = 1; i < a.length; i++) {
      int sI = sLast + sum - a.length*a[a.length - i];
      sMax = Math.max(sMax, sI);
      sLast = sI;
    }

    return sMax;
  }

  public static void main(String[] args) {
    System.out.println(maxSumIarrI(new int[] {10, 0, 0, 10}));
  }
}
