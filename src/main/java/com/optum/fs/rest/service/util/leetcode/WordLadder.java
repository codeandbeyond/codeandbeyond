package com.optum.fs.rest.service.util.leetcode;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log","cog"};
        WordLadder wordLadder = new WordLadder();
        int length = wordLadder.ladderLength(beginWord, endWord, Arrays.asList(wordList));
        System.out.println(length);
        System.out.println(wordLadder.findLadders(beginWord, endWord, Arrays.asList(wordList)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        if(!wordSet.contains(endWord)) return 0;
        int level = 1;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordChar = word.toCharArray();
                for (int j = 0; j < wordChar.length; j++) {
                    char originalChar = wordChar[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        wordChar[j] = c;
                        String newWord = String.valueOf(wordChar);
                        if (newWord.equals(endWord)) return level + 1;
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordChar[j] = originalChar;

                }

            }
            level++;
        }


        return 0;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList();
        Set<String> wordSet = new HashSet(wordList);
        if(!wordSet.contains(endWord)) return result;
        Map<String,List<String>> graph = new HashMap<>();
        Set<String> currLevel = new HashSet<>();
        currLevel.add(beginWord);
        boolean endFound = false;
        while(!endFound && !currLevel.isEmpty()){
            wordSet.removeAll(currLevel);
            Set<String> nextLevel = new HashSet<>();
            for(String s:currLevel){
                graph.put(s,new ArrayList<>());
                char[] curr = s.toCharArray();
                for(int i=0;i<curr.length;i++){
                    char originalChar = curr[i];
                    for(char c = 'a';c<'z';c++){
                        if(originalChar ==c) continue;
                        curr[i] = c;
                        String key = String.valueOf(curr);
                        if(endWord.equals(key)){
                            endFound = true;
                        }
                        if(!wordSet.contains(key)) continue;
                        graph.get(s).add(key);
                        nextLevel.add(key);
                    }
                    curr[i] = originalChar;
                }
            }
            currLevel = nextLevel;
        }
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        addPath(beginWord,endWord,graph,list,result);
        return result;

    }

    private void addPath(String from, String to, Map<String, List<String>> graph, List<String> list, List<List<String>> result) {
        if(from.equals(to)){
            result.add(new ArrayList<>(list));
            return;
        }
        if(!graph.containsKey(from)) return;
        for(String next:graph.get(from)){
            list.add(next);
            addPath(next,to,graph,list,result);
            list.remove(list.size()-1);
        }
    }
}
