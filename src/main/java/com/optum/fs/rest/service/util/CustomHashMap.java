package com.optum.fs.rest.service.util;

public class CustomHashMap {
    class ListNode {
        int key;
        int value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    final ListNode[] nodes = new ListNode[100001];

    public void put(int key, int value) {
        int i = idx(key);
        if (nodes[i] == null) {
            nodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = findNode(nodes[i], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int i = idx(key);
        if (nodes[i] == null) {
            return -1;
        }
        ListNode prev = findNode(nodes[i], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    private ListNode findNode(ListNode bucket, int key) {
        ListNode node = bucket;
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    private int idx(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.put(2, 6);
        System.out.println(customHashMap.get(2));
    }
}
