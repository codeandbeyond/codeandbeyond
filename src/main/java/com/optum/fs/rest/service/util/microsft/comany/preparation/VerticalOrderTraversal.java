package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(){

    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(TreeNode left, TreeNode right,int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
public class VerticalOrderTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>  map = new TreeMap();
        dfs(map,0,0,root);
        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> value:map.values()){
           result.add(new ArrayList());
            for(PriorityQueue<Integer> nodes:value.values()){
                while(!nodes.isEmpty()){
                    result.get(result.size()-1).add(nodes.poll());
                }
            }
        }

        return result;

    }

    private void dfs(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int x, int y, TreeNode root) {
        if(root == null) return;
        if(!map.containsKey(x)){
            map.put(x,new TreeMap<>());
        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y,new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.val);
        dfs(map,x-1,y+1,root.left);
        dfs(map,x+1,y+1,root.right);
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> pairs = new LinkedList<>();
        pairs.offer(new Pair(root, 0));
        int min = 0;
        int max = 0;
        while(!pairs.isEmpty()) {
            Pair curr = pairs.poll();
            TreeNode node = curr.node;
            int order = curr.order;
            min = Math.min(min, order);
            max = Math.max(max, order);
            if(!map.containsKey(order)) {
                map.put(order, new ArrayList<>());
            }
            map.get(order).add(node.val);
            if(node.left != null) {
                pairs.offer(new Pair(node.left, order-1));
            }
            if(node.right != null) {
                pairs.offer(new Pair(node.right, order+1));
            }
        }
        for(int i = min; i <= max; i++) {
            if(map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }

}
class Pair {
    TreeNode node;
    int order;
    public Pair(TreeNode n, int i) {
        node = n;
        order = i;
    }
}
