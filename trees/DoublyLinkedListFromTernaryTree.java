// https://www.geeksforgeeks.org/create-doubly-linked-list-ternary-ree/

class Main {

  public static void construct(Node root) {
    if (root == null) return;
    Node last = construct(null, root);

    Node cur = last;
    while (cur.left != null) {
      cur.left.right = cur;
      cur = cur.left;
    }
  }

  // returns last visited node in tree (in pre-order), with root `root`
  private static Node construct(Node prev, Node root) {

    Node last = root;
    if (root.left != null) {
      last = construct(last, root.left);
    }
    if (root.mid != null) {
      last = construct(last, root.mid);
    }
    if (root.right != null) {
      last = construct(last, root.right);
    }

    root.left = prev;

    return last;
  }

  public static void main(String[] args) {
    Node root = new Node(30);
    root.left = new Node(5);
    root.mid = new Node(11);
    root.right = new Node(63);

    root.left.left = new Node(1);
    root.left.mid = new Node(4);
    root.left.right = new Node(8);

    root.mid.left = new Node(6);
    root.mid.mid = new Node(7);
    root.mid.right = new Node(15);

    root.right.left = new Node(31);
    root.right.mid = new Node(55);
    root.right.right = new Node(65);

    construct(root);

    root.print();
  }

  private static class Node {
    int value;
    Node left, mid, right;

    private Node(int value) {
      this.value = value;
    }

    private boolean isLeaf() {
      return left == null && mid == null && right == null;
    }

    private void print() {
      System.out.print(value + " <-> ");
      if (right != null) right.print();
    }

    private void printBack() {
      System.out.print(value + " <- ");
      if (left != null) left.printBack();
    }

    public String toString() {
      return "" + value;
    }
  }
}
