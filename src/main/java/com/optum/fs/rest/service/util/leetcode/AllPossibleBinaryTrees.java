package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleBinaryTrees {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int in[] = {4, 5, 7};
        int n = in.length;
        AllPossibleBinaryTrees tree = new AllPossibleBinaryTrees();
        List<Node> trees = tree.getTrees(in, 0, n - 1);
        System.out.println("Preorder traversal of different " +
                " binary trees are:");
        for (int i = 0; i < trees.size(); i++) {
            tree.preOrder(trees.get(i));
            System.out.println("");
        }
    }

    private List<Node> getTrees(int[] in, int start, int end) {
        List<Node> totalTrees = new ArrayList<>();
        if (start > end) {
            totalTrees.add(null);
            return totalTrees;
        }
        for (int i = start; i <= end; i++) {
            List<Node> lTrees = getTrees(in, start, i - 1);
            List<Node> rTrees = getTrees(in, i + 1, end);
            for (int l = 0; l < lTrees.size(); l++) {
                for (int j = 0; j < rTrees.size(); j++) {
                    Node node = new Node(in[i]);
                    node.left = lTrees.get(l);
                    node.right = rTrees.get(j);
                    totalTrees.add(node);
                }
            }
        }
        return totalTrees;
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);

        }
    }
}
