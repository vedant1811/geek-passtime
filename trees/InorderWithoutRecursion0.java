import java.util.*;

class Main {
  public static void traverse(Node root) {
    if (root == null) return;
    Stack<Node> stack = new Stack<>();
    Node cur = root;
    while (!stack.isEmpty() || cur != null) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.pop();
        System.out.print(cur + ", ");
        cur = cur.right;
      }
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
    root.right.left.right = new Node(8);

    traverse(root);
  }
}
