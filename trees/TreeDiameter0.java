// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/ with path

import java.util.*;

class Main {

  /*
   * path of diameter
   */
  private static List<Node> path = null;
  private static List<Node> diameter(Node root) {
    List<Node> left = diameter(root.left);
    List<Node> right = diameter(root.right);
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

    System.out.println("diameter = " + diameter(root));
  }
}
