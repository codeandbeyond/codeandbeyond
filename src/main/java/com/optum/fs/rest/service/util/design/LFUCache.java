package com.optum.fs.rest.service.util.design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    int capacity;
    int curSize;
    int minFreq;
    Map<Integer, Node> cache;
    Map<Integer, DLL> freqMap;

    LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }

    public void put(int key,int val){
        if(capacity == 0) return;

        Node node = cache.get(key);
        if(node == null){
           curSize++;
           if(curSize > capacity){
               DLL minFreqList = freqMap.get(minFreq);
               Node minFreqNode = minFreqList.popTail();
               cache.remove(minFreqNode.key);
               curSize--;
           }
           minFreq = 1;
           Node newNode = new Node(key,val);
           DLL newMinFreqList = freqMap.getOrDefault(1,new DLL());
            newMinFreqList.addNode(newNode);
           freqMap.put(1,newMinFreqList);
           cache.put(key,newNode);
        }else{
            node.key = key;
            node.value = val;
            update(node);
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.removeNode(node);
        if (list.size == 0 && freq == minFreq) {
            minFreq++;
        }
        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }



    class Node {
        int key;
        int value;
        int freq;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        int size;
        Node head;
        Node tail;

        DLL() {
            this.size = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public void addNode(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            size++;
        }

        public Node removeNode(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            size--;
            return node;
        }

        public Node popTail() {
            if (size > 0) {
                Node pre = tail.pre;
                removeNode(pre);
                return pre;
            }
            return null;
        }
    }
}
