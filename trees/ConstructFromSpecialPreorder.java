class Main {
  private static int i = 0;
  public static Node construct(int[] pre, char[] type) {
    Node node = new Node(pre[i]);
    if (type[i++] == 'N') {
      node.left = construct(pre, type);
      node.right = construct(pre, type);
    }
    return node;
  }

  public static void main(String[] args) {
    int[] pre = {10, 30, 20, 5, 15};
    char[] type = {'N', 'N', 'L', 'L', 'L'};
    Node root = construct(pre, type);
    root.printInorder();
  }
}
