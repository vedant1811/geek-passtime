import java.util.*;

class Main {

  public static Node create(int[] inorder, int[] level) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < level.length; i++ ) {
      map.put(level[i], i);
    }

    return create(inorder, map, 0, inorder.length - 1);
  }

  public static Node create(int[] inorder, Map<Integer, Integer> map, int start, int end) {
    int min = Integer.MAX_VALUE, minI = -1;
    for (int i = start; i <= end; i++) {
      int index = map.get(inorder[i]);
      if (index < min) {
        min = index;
        minI = i;
      }
    }
    if (min != Integer.MAX_VALUE) {
      Node node = new Node(inorder[minI]);
      node.left = create(inorder, map, start, minI - 1);
      node.right = create(inorder, map, minI + 1, end);
      return node;
    }
    return null;
  }

  public static void main(String[] args) {
    int[] inorder = {4, 2, 1, 3};
    int[] levelorder = {1, 2, 3, 4};

    Node root = create(inorder, levelorder);

    root.printInorder();
  }
}
