// https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/

class Main {
  public static Node construct(int[] array) {
    int n = array.length;
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i);
    }

    Node root = null;
    for (int i = 0; i < n; i++) {
      if (array[i] == -1) {
        root = nodes[i];
        continue;
      }
      Node parent = nodes[array[i]];
      Node child = nodes[i];
      if (parent.left == null) parent.left = child;
      else parent.right = child;
    }

    return root;
  }

  public static void main(String[] args) {
    int[] parent = {1, 5, 5, 2, 2, -1, 3};
    Node root = construct(parent);
    root.printInorder();
  }
}
