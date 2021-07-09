package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.*;

public class WebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> userListMap = new HashMap();
        for (int i = 0; i < username.length; i++) {
            userListMap.putIfAbsent(username[i], new ArrayList());
            userListMap.get(username[i]).add(new Pair(website[i], timestamp[i]));
        }
        String res = "";
        Map<String, Integer> countMap = new HashMap<>();
        for (String name : userListMap.keySet()) {
            Set<String> set = new HashSet<>();
            List<Pair> list = userListMap.get(name);
            Collections.sort(list, (a, b) -> (a.time - b.time));
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String str = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if (!set.contains(str)) {
                            set.add(str);
                            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
                        }
                        if (res.equals("") || countMap.get(res) < countMap.get(str) || (countMap.get(str) == countMap.get(res) && res.compareTo(str) > 0)) {
                            res = str;
                        }
                    }
                }
            }

        }
        List<String> results = new ArrayList();
        for (String web : res.split(" ")) {
            results.add(web);
        }
        return results;

    }

    public static void main(String[] args) {
        String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        WebsiteVisitPattern websiteVisitPattern = new WebsiteVisitPattern();
        List<String> results = websiteVisitPattern.mostVisitedPattern(username, timestamp, website);
        for (String res : results) {
            System.out.println(res + " ");
        }

    }

}

class Pair {
    String web;
    int time;

    Pair(String web, int time) {
        this.web = web;
        this.time = time;
    }
}
