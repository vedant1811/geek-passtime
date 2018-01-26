// https://www.geeksforgeeks.org/check-if-leaf-traversal-of-two-binary-trees-is-same/

import java.util.*;

class Main {
  public static boolean check(Node root1, Node root2) {
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.push(root1);
    stack2.push(root2);

    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      Node leaf = null;
      while (!stack1.isEmpty()) {
        Node node = stack1.pop();
        if (node == null) continue;
        stack1.push(node.left);
        stack1.push(node.right);
        if (node.left == null && node.right == null) {
          leaf = node;
          break;
        }
      }

      while (!stack2.isEmpty()) {
        Node node = stack2.pop();
        if (node == null) continue;
        stack2.push(node.left);
        stack2.push(node.right);
        if (node.left == null && node.right == null) {
          if (leaf == null || leaf.value != node.value) return false;
          break;
        }
      }
    }

    return true;
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
