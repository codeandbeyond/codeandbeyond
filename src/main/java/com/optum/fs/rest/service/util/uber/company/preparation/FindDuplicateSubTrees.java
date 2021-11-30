package com.optum.fs.rest.service.util.uber.company.preparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

public class FindDuplicateSubTrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList();
        if (root == null) return result;
        collect(root, new HashMap<String, Integer>(), result);
        return result;
    }

    private String collect(TreeNode root, HashMap<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + collect(root.left, map, result) + "," + collect(root.right, map, result);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            result.add(root);
        }
        return serial;
    }
}
