// https://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/

import java.util.*;

class Main {
  public static Node construct(int[] pre, int[] post) {
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    for (int n : post) {
      set.add(n);
    }

    return construct(pre, set);
  }

  private static int i = 0;
  private static Node construct(int[] pre, LinkedHashSet<Integer> set) {
    // no need for a terminal condition!

    Node node = new Node(pre[i++]);
    int first = set.iterator().next();
    set.remove(node.value);

    // if node is the first element in the preorder (that has not been visited), it must be a leaf.
    if (first == node.value) {
      return node;
    }
    node.left = construct(pre, set);
    node.right = construct(pre, set);
    return node;
  }

  public static void main(String[] args) {
    int[] preorder = {1, 2, 4, 8, 9, 5, 3, 6, 7};
    int[] postorder = {8, 9, 4, 5, 2, 6, 7, 3, 1};

    Node root = construct(preorder, postorder);

    root.printInorder();
  }
}
