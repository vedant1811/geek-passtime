// Question 2

// Given the following TreeNode class:
public class TreeNode
{
 // The value held by the node
 public int Value { get; }
 // A link to the parent node in the tree
 public TreeNode Parent { get; }
 // A link to the left child node in the tree
 public TreeNode Left { get; }
 // A link to the right child node in the tree
 public TreeNode Right { get; }
}

// Write a function LowestCommonAncestor taking two nodes in the tree as a parameter and returning the
// lowest common ancestor for these two nodes.
// Explain the complexity of your solution.

import java.util.*;
import java.lang.IllegalStateException;

public class Main {

  // Time complexity is O(m + n) where m is the number of ancestors of node1, and
  // n is the number of ancestors of node2
  public static TreeNode LowestCommonAncestor(TreeNode node1, TreeNode node2) {
    // store the set of visited parents
    Set<TreeNode> parents = new HashSet<>();
    TreeNode parent1 = node1;
    TreeNode parent2 = node2;

    while (parent1 != null || parent2 != null) {
      // visiting parent1 again, must be a common ancestor
      if (parents.contains(parent1))
        return parent1;

      if (parent1 != null)
      {
        parents.add(parent1);
        parent1 = parent1.Parent();
      }

      // visiting parent2 again, must be a common ancestor
      if (parents.contains(parent2))
        return parent2;

      if (parent2 != null)
      {
        parents.add(parent2);
        parent2 = parent2,Parent()
      }
    }

    throw new IllegalStateException("No common ancestor");
  }
}
