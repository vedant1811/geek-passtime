// https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/

class Main {
  public static boolean sumPossible(Node root, int sum) {
    if (root == null) return sum == 0;

    return sumPossible(root.left, sum - root.value) || sumPossible(root.right, sum - root.value);
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

    System.out.println("sumPossible = " + sumPossible(root, 11));
  }
}
