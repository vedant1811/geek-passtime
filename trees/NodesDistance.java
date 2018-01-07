// https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/

/**
 * Assumes that values are not repeated
 */
class Main {
  public static int distance(Node root, int val1, int val2) {
    lca(root, val1, val2);
    if (sLca == null) return -1;

    return distance(sLca, val1) + distance(sLca, val2);
  }

  private static Node sLca;
  /**
   * returns the number of matching values (from val1 and val2) in root and children
   */
  public static int lca(Node root, int val1, int val2) {
    if (root == null) return 0;

    int ans = 0;
    if (root.value == val1) ans++;
    if (root.value == val2) ans++;

    ans += lca(root.left, val1, val2);
    ans += lca(root.right, val1, val2);

    if (ans == 2) { // we just found the lowest common ancestor
      sLca = root;
      ans = 7;
    }

    return ans;
  }

  private static int distance(Node root, int val) {
    if (root == null) return Integer.MIN_VALUE;
    if (root.value == val) return 0;

    int distance = Math.max(distance(root.left, val), distance(root.right, val));
    return distance + 1;
  }

  public static void main(String[] args) {
    // Let us create binary tree given in the above example
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);

    System.out.println("distance = " + distance(root, 4, 6));
  }
}
