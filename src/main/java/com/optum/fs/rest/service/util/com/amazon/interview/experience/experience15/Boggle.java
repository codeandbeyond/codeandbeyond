package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import com.optum.fs.rest.service.util.problems.tries.TrieSearchTree;

public class Boggle {
    static TrieSearchTree<String> trie = new TrieSearchTree<String>();

    public static void main(String[] args) {
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};
        for (int i = 0; i < dictionary.length; i++)
            trie.put(dictionary[i], dictionary[i]);

        char boggle[][] = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'},
                {'R', 'O', 'F'}
        };

        findWords(boggle, trie);
    }

    private static void findWords(char[][] boggle, TrieSearchTree<String> trie) {
        for (int i = 0; i < boggle.length; i++) {
            for (int j = 0; j < boggle[0].length; j++) {
                if (isSafe(i, j)) {
                    for (String key : trie.keysWithPrefix(boggle[i][j] + "")) {
                        String value = trie.get(key);
                        if (value != null) {
                            System.out.println(value);
                        }

                    }
                }
            }
        }
    }

    static boolean isSafe(int i, int j) {
        return (i >= 0 && i < 4 && j >= 0 &&
                j < 3);
    }
}
