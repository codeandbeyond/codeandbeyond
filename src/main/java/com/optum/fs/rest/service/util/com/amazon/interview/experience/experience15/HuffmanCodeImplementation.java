package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCodeImplementation {
    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};
        PriorityQueue<HuffManNode> pq = new PriorityQueue<>(n, new MyComparator());
        for (int i = 0; i < charArray.length; i++) {
            HuffManNode huffManNode = new HuffManNode();
            huffManNode.data = charfreq[i];
            huffManNode.c = charArray[i];
            huffManNode.left = null;
            huffManNode.right = null;
            pq.add(huffManNode);
        }
        HuffManNode root = null;
        while (pq.size() > 1) {
            HuffManNode x = pq.peek();
            pq.poll();
            HuffManNode y = pq.peek();
            pq.poll();

            HuffManNode f = new HuffManNode();
            f.data = x.data + y.data;
            f.c = '-';

            f.left = x;
            f.right = y;

            root = f;
            pq.add(f);
        }
        printHuffmanCoding(root, "");
    }

    private static void printHuffmanCoding(HuffManNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printHuffmanCoding(root.left, s + "0");
        printHuffmanCoding(root.right, s + "1");
    }

}

class HuffManNode {
    int data;
    char c;
    HuffManNode left;
    HuffManNode right;

}

class MyComparator implements Comparator<HuffManNode> {


    @Override
    public int compare(HuffManNode o1, HuffManNode o2) {
        return o1.data - o2.data;
    }
}
