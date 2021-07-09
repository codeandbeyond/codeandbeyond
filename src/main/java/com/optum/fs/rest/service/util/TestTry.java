package com.optum.fs.rest.service.util;

public class TestTry {
    public static void main(String[] args) {

    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer key;
        TreeNode(Integer key){
            this.key = key;
        }
    }

    public Integer getMax(TreeNode root){
        TreeNode maxNode = getMaxNode(root);
        if(maxNode!=null) return maxNode.key;
        else return Integer.MIN_VALUE;
    }
    public TreeNode getMaxNode(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.right == null) return root;
        return getMaxNode(root.right);
    }
    TreeNode max;
    TreeNode secondMax;
    public void secondMax(TreeNode root){
        if(root!=null){
            secondMax(root.right);
            if(max==null){
                max = root;
            }else{
                secondMax = root;
                return;

            }
           secondMax(root.left);
        }

    }
}
