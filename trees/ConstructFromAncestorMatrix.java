// https://www.geeksforgeeks.org/construct-tree-from-ancestor-matrix/

import java.util.*;

class Main {
  public static Node construct(int[][] matrix) {
    int n = matrix.length;

    // setup nodes
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i);
    }

    // setup count of children, sorted in ascending order
    TreeMap<Integer, List<Integer>> counts = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) count++;
      }
      if (count > 0) { // ignore zero count
        List<Integer> rowIs = counts.get(count);
        if (rowIs == null) {
          rowIs = new ArrayList<>();
          counts.put(count, rowIs);
        }
        rowIs.add(i);
      }
    }

    // now iterate
    Node parent = null, child;
    Set<Integer> created = new HashSet<>();
    for (List<Integer> rowIs : counts.values()) {
      for (int i : rowIs) {
        parent = nodes[i];
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == 1 && !created.contains(j)) {
            child = nodes[j];
            if (child == null) continue;

            if (parent.left == null) parent.left = child;
            else parent.right = child;

            // now don't let any other node be its parent
            created.add(j);
          }
        }
      }
    }

    // last parent is root
    return parent;
  }

  public static void main(String[] args) {
    int mat[][] = {
      { 0, 0, 0, 0, 0, 0 },
      { 1, 0, 0, 0, 1, 0 },
      { 0, 0, 0, 1, 0, 0 },
      { 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0 },
      { 1, 1, 1, 1, 1, 0 }
    };

    Node root = construct(mat);
    root.printInorder();
  }
}
