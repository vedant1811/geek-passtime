// https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/

import java.util.*;

/**
 Time complexity is the number of times we iterate in the array.
 which is SUM(l.2^(l - 1)) for a balanced binary tree where l is number of levels.
 = O(l.2^l) or, O(n log n)
 and O(n^2) for linked-list
 */
class Main {
  public static void paths(Node root, int k, List<Mapping> argList) {
    if (root == null) return;

    List<Mapping> list = new ArrayList<>();
    list.add(new Mapping(root.value, "" + root.value + " "));
    if (root.value == k) System.out.println(root.value);
    for (Mapping map : argList) {
      Mapping newMap = new Mapping(map.k + root.value, map.path + root.value + " ");
      list.add(newMap);
      if (newMap.k == k) System.out.println(newMap.path);
    }
    paths(root.left, k, list);
    paths(root.right, k, list);
  }

  public static void main(String[] args) {
    Node root = new Node(1);

    root.left = new Node(3);
    root.right = new Node(-1);

    root.left.left = new Node(2);
    root.left.right = new Node(1);
    root.right.left = new Node(4);
    root.right.right = new Node(5);

    root.left.right.left = new Node(1);
    root.right.left.left = new Node(1);
    root.right.left.right = new Node(2);
    root.right.right.right = new Node(6);

    paths(root, 5, new ArrayList<Mapping>());
  }

  private static class Mapping {
    final int k;
    final String path;
    Mapping(int k, String path) {
      this.k = k;
      this.path = path;
    }

    @Override
    public String toString() {
      return "" + k + " -> " + path;
    }
  }
}
