import java.util.*;

class Main {
  public static void setZeroes(ArrayList<List<Integer>> a) {
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.size(); j++) {
        if (a.get(i).get(j) == 0) {
          for (int k = 0; k < a.size(); k++) {
            a.get(i).set(k, 2);
            a.get(k).set(j, 2);
          }
          break;
        }
      }
    }
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.size(); j++) {
        if (a.get(i).get(j) == 2) {
          a.get(i).set(j, 0);
        }
        System.out.println(i + "---222 " + j + " " + a.get(i).get(j));
      }
      System.out.println(i + "---111 " + " ");
    }
  }

  public static void main(String[] args) {
    ArrayList<List<Integer>> a = new ArrayList<>();
    a.add(Arrays.asList(new int[] {0, 0}));
    a.add(Arrays.asList(new int[] {1, 1}));

    setZeroes(a);

    System.out.println(a);
  }
}
