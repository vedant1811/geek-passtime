// https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/

import java.util.*;

class Main {
  public static Node construct(int[] in, int[] post) {
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      inMap.put(in[i], i);
    }
    i = post.length-1;
    return construct(inMap, 0, i, post);
  }

  private static int i;
  private static Node construct(Map<Integer, Integer> inMap, int start, int end, int[] post) {
    if (start > end) return null;
    int rootI = inMap.get(post[i]);
    // if (rootI < start || root > end) return null;
    Node root = new Node(post[i--]);
    root.right = construct(inMap, rootI + 1, end, post);
    root.left = construct(inMap, start, rootI - 1, post);
    return root;
  }

  public static void main(String[] args) {
    int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
    int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
    Node root = construct(in, post);
    root.printInorder();
  }
}
