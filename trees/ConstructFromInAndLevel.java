class Main {

  public static Node create(int[] inorder, int[] level, int start, int end) {
    for (int value : level) {
      for (int i = start; i <= end; i++) {
        if (inorder[i] == value) {
          Node node = new Node(value);
          node.left = create(inorder, level, start, i - 1);
          node.right = create(inorder, level, i + 1, end);
          return node;
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] inorder = {4, 2, 1, 3};
    int[] levelorder = {1, 2, 3, 4};

    Node root = create(inorder, levelorder, 0, inorder.length - 1);

    root.printInorder();
  }
}
