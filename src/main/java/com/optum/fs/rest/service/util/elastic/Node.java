package com.optum.fs.rest.service.util.elastic;

class TreeNode {
    TreeNode left;
    TreeNode right;
    String val;

    TreeNode(String val) {
        this.val = val;
    }

    public int evaluate() {
        return dfs(this);
    }

    public int dfs(TreeNode root) {
        int res = 0;
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.val);
        } else {
            int left = dfs(root.left);
            int right = dfs(root.right);
            String op = root.val;
            if (op.equals("+")) {
                res = left + right;
            } else if (op.equals("-")) {
                res = left - right;
            } else if (op.equals("*")) {
                res = left * right;
            } else if (op.equals("/")) {
                res = left / right;
            }


        }
        return res;
    }
}