// print all possible substings containing 0 or more chars in a String.

class Main {

  public static void printAll(String s, String out, int i) {
    if (i >= s.length()) {
      System.out.println(out);
      return;
    }

    printAll(s, out + s.charAt(i), i + 1);
    printAll(s, out, i + 1);
  }

  public static void main(String[] args) {
    printAll("Hello", "", 0);
  }
}
