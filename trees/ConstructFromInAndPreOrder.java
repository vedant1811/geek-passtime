// https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

class Main {

  private static int p = 0;
  public static Node construct(int[] inorder, int[] preorder, int startI, int endI) {
    if (startI > endI) return null;

    Node root = new Node(preorder[p++]);

    if (startI == endI) return root;

    int i = find(inorder, root.value, startI, endI);

    root.left = construct(inorder, preorder, startI, i - 1);
    root.right = construct(inorder, preorder, i + 1, endI);

    return root;
  }

  private static int find(int[] inorder, int value, int start, int end) {
    for (int i = start; i <= end; i++) {
      if (inorder[i] == value) return i;
    }
    throw new RuntimeException();
  }

  public static void main(String[] args) {
    int[] inorder = {4, 2, 1, 3};
    int[] preorder = {1, 2, 4, 3};

    Node root = construct(inorder, preorder, 0, inorder.length - 1);

    root.printInorder();
  }
}
