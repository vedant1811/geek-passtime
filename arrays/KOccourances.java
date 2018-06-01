// https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/

import java.util.*;

class Main {
  public static void kOccourances(Integer[] a, int k) {
    if (k == 0 || a == null || a.length == 0) return;

    Map<Integer, Integer> map = new HashMap<>();

    for (int n : a) {
      int count = 0;
      if (map.containsKey(n)) {
        count = map.get(n);
      }
      map.put(n, count + 1);
    }

    Arrays.sort(a, (n1, n2) -> {
      int count1 = map.get(n1);
      int count2 = map.get(n2);

      if (count1 != count2) return count2 - count1;

      return n2 - n1;
    });

    int last = a[0];
    System.out.print(a[0] + " ");
    for (int i = 1; i < a.length; i++) {
      if (last == a[i]) continue;

      System.out.print(a[i] + " ");
      last = a[0];
      k--;
      if (k == 1) break;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] a = {1, 2, 1, 4, 5, 6, 4, 5, 5, 4,4};

    kOccourances(a, 2);
  }
}
