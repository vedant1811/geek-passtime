// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/

// O(n) solution
class Main {
  public static int maxProfit(int[] a) {
    if (a == null || a.length == 0) return 0;
    int min = a[0];
    int[] profits = new int[a.length];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > min) {
        profits[i] = a[i] - min;
      } else {
        min = a[i];
      }
      // store the max possible profit so far
      profits[i] = Math.max(profits[i], profits[i - 1]);
    }
    // now profits[i] contains the max possible profit from 0 to i

    int maxProfit = profits[profits.length - 1];

    int max = a[a.length - 1];
    profits[profits.length - 1] = 0; // reset
    for (int i = a.length - 2; i >= 0; i--) {
      int rightI = i + 1;
      if (a[rightI] < max) {
        profits[rightI] = max - a[rightI];
      } else {
        max = a[rightI];
      }
      if (rightI < a.length - 1) profits[rightI] = Math.max(profits[rightI], profits[rightI + 1]);
      maxProfit = Math.max(maxProfit, profits[i] + profits[rightI]);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {10, 22, 5, 75, 65, 80}));
    System.out.println(maxProfit(new int[] {2, 30, 15, 10, 8, 25, 80}));
    System.out.println(maxProfit(new int[] {100, 30, 15, 10, 8, 25, 80}));
    System.out.println(maxProfit(new int[] {90, 80, 70, 60, 50}));
  }
}
