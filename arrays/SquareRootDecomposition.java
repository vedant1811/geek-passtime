// https://www.geeksforgeeks.org/mos-algorithm-query-square-root-decomposition-set-1-introduction/

import java.util.*;
import java.lang.Comparable;

class Main {
  static class Query implements Comparable {
    final int l, r;
    Query(int l, int r) {
      this.l = l;
      this.r = r;
    }

    @Override
    public int compareTo(Object o) {
      Query other = (Query) o;
      if (l/bucketSize != other.l/bucketSize) {
        return l - other.l;
      }

      return r - other.r;
    }
  }

  static int bucketSize;
  public static void querySum(int[] a, Query[] queries) {
    if (queries == null || queries.length == 0) return;
    bucketSize = (int) Math.sqrt(a.length);
    Arrays.sort(queries);

    int sum = 0;
    for (int i = queries[0].l; i <= queries[0].r; i++) {
        sum+= a[i];
    }
    System.out.println("Q0:\t" + sum);

    for (int q = 1; q < queries.length; q++) {
      for (int i = queries[q-1].l; i < queries[q].l; i++) {
        sum -= a[i];
      }

      for (int i = queries[q].l; i < queries[q-1].l; i++) {
        sum += a[i];
      }

      for (int i = queries[q-1].r + 1; i <= queries[q].r; i++) {
        sum += a[i];
      }

      for (int i = queries[q].r + 1; i <= queries[q-1].r; i++) {
        sum -= a[i];
      }
      System.out.println("Q" + q + ":\t" + sum);
    }
  }

  public static void main(String[] args) {
    int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
    Query q[] = {new Query(0, 4), new Query(1, 3), new Query(0, 8), new Query(4, 7)};
    querySum(a, q);
  }
}
