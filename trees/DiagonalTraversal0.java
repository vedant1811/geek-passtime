// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

import java.util.*;

class Main {
  public static void diagonalPrint(Node root) {
    Map<Integer, String> slopes = new HashMap<>();
    createMap(root, 0, slopes);
    for (int i = 0; i < slopes.size(); i++) {
      System.out.println(slopes.get(i));
    }
  }

  private static void createMap(Node root, int i, Map<Integer, String> slopes) {
    if (root == null) return;

    String nodes = slopes.get(i);
    if (nodes == null) {
      nodes = "";
    }
    nodes += root + " ";
    slopes.put(i, nodes);
    createMap(root.left, i + 1, slopes);
    createMap(root.right, i, slopes);
  }

  public static void main(String[] args) {
    Node root = new Node(8);
    root.left = new Node(3);
    root.right = new Node(10);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
    root.right.right = new Node(14);
    root.right.right.left = new Node(13);
    root.left.right.left = new Node(4);
    root.left.right.right = new Node(7);

    diagonalPrint(root);
  }
}
