package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ashok on 07-06-2020.
 */

public class PostOrderUsingStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.right != null) {
                //stack.push(current);
                current = current.right;
            } else {
                list.add(current.val);
                current = null;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = null;
        treeNode2.left = treeNode3;
        treeNode2.right = null;
        treeNode.right = treeNode2;
        PostOrderUsingStack post = new PostOrderUsingStack();
        post.postorderTraversal(treeNode);


    }
}
