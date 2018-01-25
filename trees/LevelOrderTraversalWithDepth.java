// https://www.geeksforgeeks.org/print-level-order-traversal-line-line/ with level

import java.util.*;

class Main {
  public static void levelTraverse(Node root) {
    if (root == null) return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    int level = 0, nodeCount = 0;

    while (!queue.isEmpty()) {
      if (nodeCount == 0) {
        nodeCount = queue.size();
        level++;
        System.out.println();
        System.out.print(level + " -> ");
      }
      Node node = queue.remove();
      System.out.print(" " + node);
      nodeCount--;
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    levelTraverse(root);
  }
}
