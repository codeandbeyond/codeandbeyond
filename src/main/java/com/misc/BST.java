package com.misc;

import java.util.PriorityQueue;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key Key;
        private Value val;
        private Node left;
        private Node right;
        int N;

        public Node(Key key, Value val, int N) {
            this.Key = key;
            this.val = val;
            this.N = N;

        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.Key);
        if (cmp > 0)
            x.right = put(x.right, key, val);
        else if (cmp < 0)
            x.left = put(x.left, key, val);
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key) {
        Value val = get(root, key);
        return val;
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.Key);
        if (cmp > 0) return get(x.right, key);
        else if (cmp < 0) return get(x.left, key);
        else return x.val;
    }

    public Key min() {
        return min(root).Key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).Key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.Key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.Key);
        if (cmp == 0) return x;
        else if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else return x;


    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.Key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.Key);
        if (cmp == 0) return x;
        else if (cmp > 0)
            return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null)
            return t;
        else return x;


    }

    public Key select(int k) {
        return select(root, k).Key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.Key);
        if (cmp < 0)
            return rank(x.left, key);
        else if (cmp > 0)
            return size(x.left) + 1 + rank(x.right, key);
        else
            return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.right) + size(x.left);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);

    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.Key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.left == null)
                return x.right;
            if (x.right == null)
                return x.left;
            else {
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void inorder() {
        if (root != null) {
            inorder(root);
        } else {
            System.out.println("Root is Empty! Nothing to Show");
        }
    }

    private void inorder(Node x) {
        if (x != null) {
            inorder(x.left);
            System.out.print(" " + x.Key + ":" + x.val);
            System.out.println();
            inorder(x.right);
        }
    }

    public void preorder() {
        if (root != null) {
            preorder(root);
        } else {
            System.out.println("Root is Empty! Nothing to Show");
        }
    }

    private void preorder(Node x) {
        if (x != null) {
            System.out.print(" " + x.Key + ":" + x.val);
            System.out.println();
            preorder(x.left);
            preorder(x.right);
        }
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new PriorityQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.Key);
        int cmphi = hi.compareTo(x.Key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.Key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    private boolean check() {
        if (!isBST()) System.out.println("Not in symmetric order");
        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
        /*if (!isRankConsistent()) System.out.println("Ranks not consistent");*/
        return isBST() && isSizeConsistent() /*&& isRankConsistent()*/;
    }

    /*private boolean isRankConsistent() {
    }*/

    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.N != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.right) && isSizeConsistent(x.left);
    }

    public boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key minValue, Key maxValue) {
        if (x == null) return true;
        if (minValue != null && x.Key.compareTo(minValue) <= 0) return false;
        if (maxValue != null && x.Key.compareTo(maxValue) >= 0) return false;
        return isBST(x.left, minValue, x.Key) && isBST(x.right, x.Key, maxValue);
    }

}
