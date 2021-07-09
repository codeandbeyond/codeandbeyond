package com.optum.fs.rest.service.util.problems.tries;


import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class TrieCustom<Value> {
    private static final int R = 256;        // extended ASCII


    private Node root;      // root of trie
    private int n;          // number of keys in trie

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        else return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);

    }

    public void put(String key, String value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, String value, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = value;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d + 1);
        return x;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> queue = new LinkedList<>();
        Node x = get(root, pre, 0);
        collect(x, new StringBuilder(pre), queue);
        return queue;
    }

    private void collect(Node x, StringBuilder pre, Queue<String> queue) {
        if (x == null) return;
        if (x.val != null) queue.add(pre.toString());
        for (char c = 0; c < R; c++) {
            pre.append(c);
            collect(x.next[c], pre, queue);
            pre.deleteCharAt(pre.length() - 1);
        }

    }

    public Iterable<String> wildcardmatch(String pat) {
        Queue<String> results = new LinkedList<>();
        collect(root, new StringBuilder(), pat, results);
        return results;
    }

    private void collect(Node x, StringBuilder pre, String pat, Queue<String> results) {
        if (x == null) return;
        int d = pre.length();
        if (d == pat.length() && x.val != null)
            results.add(pre.toString());
        if (d == pat.length())
            return;
        char c = pat.charAt(d);
        if (c == '*') {
            for (char ch = 0; ch < R; ch++) {
                pre.append(ch);
                collect(x.next[ch], pre, pat, results);
                pre.deleteCharAt(pre.length() - 1);
            }
        } else {
            pre.append(c);
            collect(x.next[c], pre, pat, results);
            pre.deleteCharAt(pre.length() - 1);
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int count = 0;
        if (x.val != null) count++;
        for (int i = 0; i < R; i++) {
            count += size(x.next[i]);
        }
        return count;
    }

    public boolean wordBreak(String word) {
        int size = word.length();
        if (size == 0) return true;
        for (int i = 1; i <= size; i++) {
            if (this.get(word.substring(0, i)) != null && wordBreak(word.substring(i, size))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TrieCustom trieCustom = new TrieCustom();
        trieCustom.put("fruit", "Banana");
        trieCustom.put("veg", "potato");
        // Iterable it = trieCustom.keysWithPrefix("ve");
        //String key = (String) it.iterator().next();
        //System.out.println(trieCustom.get(key));
        //System.out.println(trieCustom.wildcardmatch("ve*"));
//        System.out.println(trieCustom.get("Nam"));
//        System.out.println(trieCustom.get("fruit"));
//        System.out.println(trieCustom.get("veg"));
//        System.out.println(trieCustom.size());
        //trieCustom.keys();
        String dictionary[] = {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like", "ice", "cream"};
        for (String word : dictionary) {
            trieCustom.put(word, word);

        }

        Assert.assertTrue(trieCustom.wordBreak("ilikesamsung"));
        Assert.assertFalse(trieCustom.wordBreak("samsungandmangok"));
        Assert.assertTrue(trieCustom.wordBreak("ilikelikeimangoiii"));
    }
}
