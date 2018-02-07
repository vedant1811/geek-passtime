//https://www.geeksforgeeks.org/construct-ancestor-matrix-from-a-given-binary-tree/

import java.util.*;

class Main {
  public static Set<Integer> construct(Node root, int n, int rows[][]) {
    if (root == null) return new HashSet<>();

    Set<Integer> children = construct(root.left, n, rows);
    children.addAll(construct(root.right, n, rows));

    int[] row = new int[n];
    for (int j : children) {
      row[j] = 1;
    }

    rows[root.value] = row;
    children.add(root.value);
    return children;
  }

  public static void main(String[] args) {

    Node root = new Node(5);
    root.left = new Node(1);
    root.right = new Node(2);
    root.left.left = new Node(0);
    root.left.right = new Node(4);
    root.right.left = new Node(3);

    int[][] matrix = new int[6][];
    construct(root, 6, matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
}
