// https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/

/**
 * Assumes that values are not repeated, and val1 != val2
 */
class Main {
  public static int[] distance(Node root, int val1, int val2) {
    if (root == null) return [Integer.MIN_VALUE, Integer.MIN_VALUE]; // not found

    int[] ans = distance(root.left, val1, val2);

    if (root.value == val1) ans[0] = 0;
    else if (ans[1] < 0) ans[0]++;

    if (root.value == val2) ans[1] = 0;
    else if (ans[0] < 0) ans[1]++;

    int[] right = distance(root.right, val1, val2);
    
    ans[0] = Math.max(ans[0], right[0]);
    ans[1] = Math.max(ans[1], right[1]);

    return ans;
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


  }
}
