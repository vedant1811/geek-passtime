/**
 * A binary tree node with an integer value.
 */
class Node {
  public int value;
  public Node left;
  public Node right;

  public Node(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value;
  }

  public boolean isLeaf() {
    return left == null && right == null;
  }

  public void printInorder() {
    if (left != null) left.printInorder();
    System.out.print(this + " ");
    if (right != null) right.printInorder();
  }
}
