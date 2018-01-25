// https://www.geeksforgeeks.org/print-level-order-traversal-line-line/ with level
// with delimeter

import java.util.*;

class Main {
  public static void levelTraverse(Node root) {
    if (root == null) return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Delimeter(1));
    queue.add(root);

    while (!queue.isEmpty()) {
    Node node = queue.remove();
      if (node instanceof Delimeter) {
        if (queue.isEmpty()) break;

        System.out.println();
        System.out.print(node + " -> ");
        node.value++;
        queue.add(node);
        continue;
      }
      System.out.print(" " + node);
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

  private static class Delimeter extends Node {
    public Delimeter(int value) {
      super(value);
    }
  }
}
