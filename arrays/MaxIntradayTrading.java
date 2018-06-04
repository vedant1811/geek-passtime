// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/

import java.util.*;

// O(n^3) solution
class Main {
  public static int maxProfit(int[] a) {
    if (a == null || a.length == 0) return 0;

    List<Integer[]> pairs = new ArrayList<>();

    int start = 0;
    while (true) {
      int minima = nextMinima(a, start);
      if (minima == -1) break;

      int maxima = nextMaxima(a, minima + 1);
      if (maxima == -1) break;

      pairs.add(new Integer[] {a[minima], a[maxima]});
      start = maxima + 1;
    }

    int max = 0;
    for (int i = 0; i < pairs.size(); i++) {
      int left = max1Trade(pairs, 0, i);
      int right = max1Trade(pairs, i + 1, pairs.size() - 1);
      max = Math.max(max, left + right);
    }
    return max;
  }

  private static int max1Trade(List<Integer[]> pairs, int start, int end) {
    int max = 0;
    for (int i = start; i <= end; i++) {
      for (int j = i; j <= end; j++) {
        Integer[] pair1 = pairs.get(i);
        Integer[] pair2 = pairs.get(j);
        int trade = pair2[1] - pair1[0];
        max = Math.max(max, trade);
      }
    }
    return max;
  }

  private static int nextMinima(int[] a, int start) {
    for (int i = start; i < a.length; i++) {
      if ((i == 0 || a[i - 1] >= a[i]) && (i == a.length - 1 || a[i + 1] > a[i]))
        return i;
    }
    return -1;
  }

  private static int nextMaxima(int[] a, int start) {
    for (int i = start; i < a.length; i++) {
      if ((i == 0 || a[i - 1] <= a[i]) && (i == a.length - 1 || a[i + 1] < a[i]))
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {10, 22, 5, 75, 65, 80}));
    System.out.println(maxProfit(new int[] {2, 30, 15, 10, 8, 25, 80}));
    System.out.println(maxProfit(new int[] {100, 30, 15, 10, 8, 25, 80}));
    System.out.println(maxProfit(new int[] {90, 80, 70, 60, 50}));
  }
}
