// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

import java.util.*;

class Main {
  public static void diagonalPrint(Node root) {

    List<List<Node>> currentLine = new ArrayList<>();
    List<List<Node>> lowerLine = new ArrayList<>();
    List<Node> firstLine = new ArrayList<>();
    firstLine.add(root);
    currentLine.add(firstLine);

    boolean run = true;
    while (run) {
      run = false;
      for (int i = 0; i < currentLine.size() && i < 20; i++) {
        List<Node> currentCell = currentLine.get(i);
        if (currentCell.size() > 5 || currentLine.size() > 5) break;
        // System.out.println(i + " -> " + currentCell + " ---- " + currentLine);

        List<Node> nextCell;
        boolean newCell = false;
        if (currentLine.size() > i + 1)
          nextCell = currentLine.get(i + 1);
        else {
          nextCell = new ArrayList<>();
          newCell = true;
        }

        List<Node> lowerCell = new ArrayList<>();
        lowerLine.add(lowerCell);

        for (int j = 0; j < currentCell.size(); j++) {
          Node node = currentCell.get(j);
          System.out.print(node + " ");

          if (node.right != null) {
            nextCell.add(j, node.right);
          }
          if (node.left != null) {
            lowerCell.add(node.left);
            run = true;
          }
        }
        if (newCell && !nextCell.isEmpty()) currentLine.add(nextCell);
      } // one line is processed
      currentLine = lowerLine;
      lowerLine = new ArrayList<>();
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Node root = new Node(8);
    root.left = new Node(3);
    root.right = new Node(10);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
    root.right.right = new Node(14);
    root.right.right.left = new Node(13);
    root.left.right.left = new Node(4);
    root.left.right.right = new Node(7);

    diagonalPrint(root);
  }
}
