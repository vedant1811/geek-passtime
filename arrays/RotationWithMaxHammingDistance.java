// https://www.geeksforgeeks.org/find-a-rotation-with-maximum-hamming-distance/

class Main {
  public static int maxHamming(int a[]) {
    int maxHamming = 0;
    for (int r = 1; r < a.length; r++) {
      int hamming = 0;
      for (int i = 0; i < a.length; i++) {
        if (a[i] != a[(i + r) % a.length]) hamming++;
      }
      if (hamming > maxHamming) maxHamming = hamming;
    }
    return maxHamming;
  }

  public static void main(String[] args) {
    System.out.println(maxHamming(new int[] {1,4,1,0,8}));
  }
}
