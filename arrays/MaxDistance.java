// https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

class Main {
  public static int maxDistance(int[] a) {
    if (a == null || a.length <= 1) return -1;

    int[] lMin = new int[a.length];
    lMin[0] = a[0];
    for (int i = 1; i < lMin.length; i++) {
      lMin[i] = Math.min(lMin[i-1], a[i]);
    }

    int[] rMax = new int[a.length];
    rMax[rMax.length - 1] = a[a.length - 1];
    for (int i = rMax.length - 2; i >= 0; i--) {
      rMax[i] = Math.max(a[i], rMax[i+1]);
    }

    int ans = -1;
    for (int i = 0, j = 1; i < a.length && j < a.length; ) {
      if (i == j) {
        j++;
        continue;
      }

      if (lMin[i] < rMax[j]) {
        ans = Math.max(ans, j - i);
        j++;
      } else {
        i++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(maxDistance(new int[] {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}));
  }
}
