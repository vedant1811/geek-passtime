// www.geeksforgeeks.org/median-of-two-sorted-arrays

// in O(n)
class Main {
  private static int[] a1;
  private static int[] a2;
  private static int n;
  public static int median(int[] a1, int[] a2, int n) {
    Main.a1 = a1;
    Main.a2 = a2;
    Main.n = n;
    Lower lower = new Lower();
    Higher higher = new Higher();

    while (true) {
      int old = lower.moveNext();
      if (lower.current() == higher.current()) {
        return (old + higher.current()) / 2;
      }
      higher.moveNext();
    }
  }

  public static void main(String[] args) {
    int[] a1 = {1, 12, 15, 26, 38};
    int[] a2 = {2, 13, 17, 30, 45};

    System.out.println(median(a1, a2, a1.length));
  }

  private static class Lower {
    int p1, p2;
    public Lower() {
      p1 = p2 = 0;
    }

    // moves to the next higher element and returns the current highest
    int moveNext() {
      int cur = current();
      if (a1[p1] > a2[p2]) p2++;
      else p1++;
      return cur;
    }

    int current() {
      return Math.min(a1[p1], a2[p2]);
    }
  }

  private static class Higher {
    int p1, p2;
    public Higher() {
      p1 = p2 = n - 1;
    }

    void moveNext() {
      if (a1[p1] > a2[p2]) p1--;
      else p2--;
    }

    int current() {
      return Math.max(a1[p1], a2[p2]);
    }
  }
}
