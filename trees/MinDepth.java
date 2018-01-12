// https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/

import java.util.*;

class Main {
  public static int depth(Node root) {
    if (root == null) return 0;

    Queue<Node> queue = new LinkedList();
    queue.add(root);
    queue.add(null); // delimeter to signify end of level.
    int depth = 1;
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      if (node == null) {
        depth++;
        queue.add(null);
        continue;
      }
      if (node.left == null) {
        if (node.right == null) break; // leaf
        else queue.add(node.right);
      } else {
        queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
    }
    return depth;
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
