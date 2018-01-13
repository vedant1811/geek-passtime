// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/ with path

import java.util.*;

class Main {

  /*
   * path of diameter
   */
  public static List diameter(Node root) {
    List[] ans = diameterArray(root);
    return ans[0].size() >= ans[1].size() ? ans[0] : ans[1];
  }

  private static List[] diameterArray(Node root) {
    List[] ans = {new ArrayList(), new ArrayList()};
    if (root == null) return ans;

    List[] left = diameterArray(root.left);
    List[] right = diameterArray(root.right);

    ans[1] = left[1].size() >= right[1].size() ? left[1] : right[1];
    if (left[0].size() + right[0].size() >= ans[1].size()) {
      ans[1].clear();
      ans[1].addAll(left[0]);
      ans[1].add(root);
      ans[1].addAll(right[0]);
    }

    ans[0] = left[0].size() >= right[0].size() ? left[0] : right[0];
    ans[0].add(root);
    return ans;
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
