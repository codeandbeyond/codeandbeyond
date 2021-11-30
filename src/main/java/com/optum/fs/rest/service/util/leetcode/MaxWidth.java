package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;
import java.util.Map;


public class MaxWidth {
    Map<Integer, Integer> leftmostNodePosition = new HashMap<>();
    int maxWidth = 0;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode2.left=treeNode4;
        treeNode2.right=null;
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;


        MaxWidth width = new MaxWidth();
        System.out.println(width.widthOfBinaryTree(treeNode));

    }

    public int widthOfBinaryTree(TreeNode root) {


        if (root == null)
            return 0;
        dfs(root, 0, 0);
        return maxWidth;
    }

    public void dfs(TreeNode root, int depth, int position) {
        if (root == null) return;
        leftmostNodePosition.putIfAbsent(depth, position);
        maxWidth = Math.max(maxWidth, position - leftmostNodePosition.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * position);
        dfs(root.right, depth + 1, 2 * position + 1);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}