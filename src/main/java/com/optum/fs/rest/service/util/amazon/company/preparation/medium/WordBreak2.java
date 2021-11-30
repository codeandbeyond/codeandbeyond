package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = new String[]{"cat", "cats", "and", "sand", "dog"};
        WordBreak2 wordBreak2 = new WordBreak2();
        wordBreak2.wordBreak(s, new HashSet<>(Arrays.asList(wordDict)));
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
