// https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/

class Main {
  public static Node getRoot(int[] inorder, int min, int max) {
    if (min > max) return null;
    int iMax = min;
    for (int i = min + 1; i <= max; i++) {
      if (inorder[i] > inorder[iMax]) iMax = i;
    }
    Node root = new Node(inorder[iMax]);
    root.left = getRoot(inorder, min, iMax - 1);
    root.right = getRoot(inorder, iMax + 1, max);

    return root;
  }

  public static void main(String[] args) {
    int[] inorder = {1, 5, 10, 40, 30, 15, 28, 20};

    Node root = getRoot(inorder, 0, inorder.length - 1);

    root.printInorder();
  }
}
