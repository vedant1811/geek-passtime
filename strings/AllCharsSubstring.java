class Main {
  public static String allChars(String s) {
    if (s == null || s.isEmpty()) return s;

    boolean[] reqd = new boolean[128];
    int reqdLength = 0;
    for (int i = 0; i < s.length(); i++) {
      int key = s.charAt(i) - 'a';
      if (!reqd[key]) {
        reqdLength++;
        reqd[key] = true;
      }
    }

    String ans = null;
    int[] count = new int[128];

    int left = 0, right = 0, curLength = 0;

    while (left <= right && right < s.length()) {
      int i = s.charAt(right) - 'a';
      count[i]++;
      if (count[i] == 1) {
        curLength++;
      }
      System.out.println("right " + right + ", curLength " + curLength);
      if (curLength < reqdLength) {
        right++;
        continue;
      }

      while (true) {
        i = s.charAt(left) - 'a';
        count[i]--;
        System.out.println("left " + left + ", count " + count[i]);
        if (count[i] == 0) {
          if (ans == null || ans.length() > right - left + 1) {
            ans = s.substring(left, right + 1);
          }
          curLength--;
          left++;
          break;
        }
        left++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "aaa";
    System.out.println(s + " -> " + allChars(s));
  }
}
