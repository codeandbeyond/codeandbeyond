package com.optum.fs.rest.service.util.amazon.company.preparation.hard;

public class ReversePairs {
    Node root;

    class Node {
        int val;
        int count;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.count = 1;
        }
    }

    private int search(Node root, int num) {
        if (root == null) {
            return 0;
        } else if (root.val == num) {
            return root.count;
        } else if (root.val > num) {
            return root.count + search(root.left, num);
        } else {
            return search(root.right, num);
        }
    }

    public Node insert(Node root, int num) {
        if (root == null) {
            root = new Node(num);
        } else if (num > root.val) {
            root.count += 1;
            root.right = insert(root.right, num);
        } else if (num < root.val) {
            root.left = insert(root.left, num);
        } else {
            root.count++;
        }
        return root;
    }

    public int reversePairs(int[] nums) {
        root = null;
        int res = 0;
        for (int num : nums) {
            res += search(root, 2 * num+1);
            root = insert(root, num);
        }
        return res;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = {2, 4, 3, 5, 1};
        int result = reversePairs.reversePairs(nums);
        System.out.println("Result = " + result);
    }
}
