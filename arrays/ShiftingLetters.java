// https://leetcode.com/contest/weekly-contest-88/problems/maximize-distance-to-closest-person/

class Main {
  public static String shiftingLetters(String S, int[] shifts) {
    int shift = 0;
    char[] chars = S.toCharArray();
    for (int i = shifts.length - 1; i >= 0; i--) {
        shift = (shift + shifts[i] % 26) % 26;
        chars[i] += shift;
        if (chars[i] > 'z') chars[i] -= 26;
    }
    return new String(chars);
  }
}
