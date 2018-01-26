class Main {
  public static void traverse(Node root) {
    traverse(root, 0, 0);
  }

  private static void traverse(Node node, int l, int d) {
    if (node == null) return;

    boolean printed = false;
    if (l == 0 || node.isLeaf()) {
      System.out.print(node.value + " ");
      printed = true;
    }

    traverse(node.left, l, d - 1);
    traverse(node.right, l + 1, d);

    if (d == 0 && !printed) System.out.print(node.value + " ");
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
    root.right.right.right = new Node(9);

    traverse(root);
  }
}
