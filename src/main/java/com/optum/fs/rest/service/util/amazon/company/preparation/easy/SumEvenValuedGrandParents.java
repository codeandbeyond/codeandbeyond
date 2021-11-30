package com.optum.fs.rest.service.util.amazon.company.preparation.easy;


   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SumEvenValuedGrandParents {
    public static void main(String[] args) {

    }
    public static int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return sum;
    }

    void dfs(TreeNode current, TreeNode parent, TreeNode grandParent) {
        if (current == null) return; // base case
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += current.val;
        }
        dfs(current.left, current, parent);// ( newChild, parent, GrandParent)
        dfs(current.right, current, parent);
    }

}
