// https://www.geeksforgeeks.org/print-level-order-traversal-line-line/ with level
// with 2 queues
import java.util.*;

class Main {
  public static void levelTraverse(Node root) {
    if (root == null) return;

    Queue<Node> queue1 = new LinkedList<>();
    Queue<Node> queue2 = new LinkedList<>();
    queue2.add(root);
    int level = 0;

    while (!queue1.isEmpty() || !queue2.isEmpty()) {
      if (queue1.isEmpty()) {
        Queue<Node> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        level++;
        System.out.println();
        System.out.print(level + " -> ");
      }

      Node node = queue1.remove();
      System.out.print(" " + node);
      if (node.left != null) queue2.add(node.left);
      if (node.right != null) queue2.add(node.right);
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
