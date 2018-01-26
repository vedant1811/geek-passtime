// https://www.geeksforgeeks.org/print-binary-tree-vertical-order/

import java.util.*;

class Main {
  private static int max, min; // both = 0
  public static void verticalTraversal(Node root) {
    Map<Integer, String> map = new HashMap<>();
    createMap(root, map, 0);

    for (int i = min; i <= max; i++) {
      System.out.println(map.get(i));
    }
  }

  private static void createMap(Node node, Map<Integer, String> map, int i) {
    if (node == null) return;

    String line = map.get(i);
    if (line == null) {
      if (i > max) max = i;
      else if (i < min) min = i;
      line = "";
    }

    map.put(i, line + node.value + " ");

    createMap(node.left, map, i - 1);
    createMap(node.right, map, i + 1);
  }

  public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    root.right.right.right = new Node(9);

    verticalTraversal(root);
  }
}
