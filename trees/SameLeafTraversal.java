// https://www.geeksforgeeks.org/check-if-leaf-traversal-of-two-binary-trees-is-same/

import java.util.*;

class Main {
  public static boolean check(Node root1, Node root2) {
    Queue<Node> queue = new LinkedList<>();

    createQueue(root1, queue);
    return checkQueue(root2, queue) && queue.isEmpty();
  }

  private static void createQueue(Node node, Queue<Node> queue) {
    if (node == null) return;

    if (node.left == null && node.right == null) {
      queue.add(node);
      return;
    }
    createQueue(node.left, queue);
    createQueue(node.right, queue);
  }

  private static boolean checkQueue(Node node, Queue<Node> queue) {
    if (node == null) return true;

    if (node.left == null && node.right == null) {
      return !queue.isEmpty() && node.value == queue.remove().value;
    }
    return checkQueue(node.left, queue) && checkQueue(node.right, queue);
  }

  public static void main(String[] args) {

    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    Node root2 = new Node(0);
    root2.left = new Node(1);
    root2.right = new Node(5);
    root2.left.right = new Node(4);
    root2.right.left = new Node(6);
    root2.right.right = new Node(7);

    if (check(root1, root2))
       System.out.println("Same");
    else
       System.out.println("Not Same");
  }
}
