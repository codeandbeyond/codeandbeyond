package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganizeString {
    public String reorganizeString(String s) {
        if(s==null || s.length()==0) return "";
        Map<Character,Integer> map = new HashMap();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue()-a.getValue()));

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> cache = pq.poll();
            if(sb.length()==0 || cache.getKey()!=sb.charAt(sb.length()-1)){
                sb.append(cache.getKey());
                cache.setValue(cache.getValue()-1);
                if(cache.getValue()!=0){
                    pq.offer(cache);
                }
            }else{
                Map.Entry<Character, Integer> cache2 = pq.poll();
                if(cache2==null){
                    return "";
                }
                sb.append(cache2.getKey());
                cache2.setValue(cache2.getValue()-1);
                if(cache2.getValue()!=0){
                    pq.offer(cache2);
                }

                pq.offer(cache);
            }

        }
        return sb.toString();
    }
}
