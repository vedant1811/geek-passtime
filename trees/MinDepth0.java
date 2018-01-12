// https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/

import java.util.*;

class Main {
  public static int depth(Node root) {
    if (root == null) return 0;

    int depth = root.left == null ? depth(root.right) :
        (root.right == null ? depth(root.left) : Math.min(depth(root.left), depth(root.right)));
    return depth + 1;
  }

  public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.right.left = new Node(6);
      root.right.right = new Node(7);

      System.out.println("depth = " + depth(root));
  }
}
