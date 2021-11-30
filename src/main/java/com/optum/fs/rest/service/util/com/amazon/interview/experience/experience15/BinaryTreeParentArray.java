package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import com.optum.fs.rest.service.util.problems.BinaryTree;

public class BinaryTreeParentArray {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        tree.createTree(parent);
        BinaryTree.printInorder();
    }
}
