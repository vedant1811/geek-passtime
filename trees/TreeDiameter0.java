// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/ with path

import java.util.*;

class Main {

  public static List<Node> diameterFunc(Node root) {
    List<Node> result = diameter(root);
    return result.size() > diameter.size() ? result : diameter;
  }

  /*
   * path of diameter
   */
  private static List<Node> diameter = new ArrayList<Node>();
  private static List<Node> diameter(Node root) {
    if (root == null) return new ArrayList<Node>();

    List<Node> left = diameter(root.left);
    List<Node> right = diameter(root.right);
    if (left.size() + right.size() >= diameter.size()) {
      diameter.clear();
      diameter.addAll(left);
      diameter.add(root);
      diameter.addAll(right);
    }

    List<Node> longer = left.size() >= right.size() ? left : right;
    longer.add(root);
    return longer;
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

    System.out.println("diameter = " + diameterFunc(root));
  }
}
