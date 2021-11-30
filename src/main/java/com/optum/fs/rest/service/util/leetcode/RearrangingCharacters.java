package com.optum.fs.rest.service.util.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangingCharacters {
    public static void main(String[] args) {
        RearrangingCharacters rearrangingCharacters = new RearrangingCharacters();
        rearrangingCharacters.rearrange("bbbaa");

    }

    private String rearrange(String str) {
        int[] charCount = new int[26];
        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }
        PriorityQueue pq = new PriorityQueue(new KeyComparator());
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                pq.add(new Key(charCount[i], (char) (i + 'a')));
            }
        }
        Key prev = new Key(-1, '#');
        String result = "";
        while (!pq.isEmpty()) {
            Key key = (Key) pq.peek();
            pq.poll();
            result += key.ch;
            if (prev.freq > 0) {
                pq.add(prev);
            }
            (key.freq)--;

            prev = key;

        }
        return result;
    }

    class Key {
        char ch;
        int freq;

        public Key(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    class KeyComparator implements Comparator<Key> {
        @Override
        public int compare(Key o1, Key o2) {
            if (o1.freq < o2.freq) {
                return 1;
            } else if (o1.freq > o2.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
