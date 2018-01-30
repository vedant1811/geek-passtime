// https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal-set-2/

import java.util.*;

class Main {
  public static void traversal(Node root) {
    if (root == null) return;
    if (root.isLeaf()) {
      System.out.print(root + " ");
      return;
    }

    Queue<Node> left = new LinkedList<>();
    Queue<Node> right = new LinkedList<>();
    left.add(root.left);
    right.add(root.right);
    right.add(null); // delimeter

    Stack<String> stack = new Stack<>();
    stack.push(root + " ");

    String line = "";
    while(true) {
      Node node2 = right.remove();
      if (node2 == null) {
        right.add(null);
        stack.push(line);
        line = "";
        node2 = right.remove();
      }

      Node node = left.remove();
      if (node == null) break;
      line += node + " ";
      left.add(node.left);
      left.add(node.right);

      line += node2 + " ";
      if (node2.isLeaf()) continue;

      right.add(node2.right);
      right.add(node2.left);
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
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

    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(11);
    root.right.left.left = new Node(12);
    root.right.left.right = new Node(13);
    root.right.right.left = new Node(14);
    root.right.right.right = new Node(15);

    root.left.left.left.left = new Node(16);
    root.left.left.left.right = new Node(17);
    root.left.left.right.left = new Node(18);
    root.left.left.right.right = new Node(19);
    root.left.right.left.left = new Node(20);
    root.left.right.left.right = new Node(21);
    root.left.right.right.left = new Node(22);
    root.left.right.right.right = new Node(23);
    root.right.left.left.left = new Node(24);
    root.right.left.left.right = new Node(25);
    root.right.left.right.left = new Node(26);
    root.right.left.right.right = new Node(27);
    root.right.right.left.left = new Node(28);
    root.right.right.left.right = new Node(29);
    root.right.right.right.left = new Node(30);
    root.right.right.right.right = new Node(31);

    traversal(root);
  }
}
