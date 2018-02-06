// Find duplicate character in a String O(1n) time with no extra space.

class Main {
  public static char duplicate(char[] s, int i) {
    int hash = s[i] % s.length;
    if (s[hash] == (char) hash) {
      return (char) hash;
    } else {
      
    }
  }

  public static void main(String[] args) {

  }
}
