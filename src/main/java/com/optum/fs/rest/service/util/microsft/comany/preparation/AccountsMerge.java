package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.*;

public class AccountsMerge {
    class UF {
        int[] id = new int[100001];

        public UF() {
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        public int find(int x) {
            while (x != id[x]) {
                x = id[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xroot = find(x);
            int yroot = find(y);

            id[xroot] = yroot;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF();
        int id = 0;
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();

        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                uf.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int index = uf.find(emailToId.get(email));
            if (!map.containsKey(index)) {
                map.put(index, new ArrayList<>());
            }
            map.get(index).add(email);
        }
        for (List<String> component : map.values()) {
            Collections.sort(component);
            component.set(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(map.values());//Create new Result arrayList adn send it as answer.
    }

    public static void main(String[] args) {
        String[][] accounts = {
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                {"John", "johnsmith@mail.com", "john00@mail.com"},
                {"Mary", "mary@mail.com"},
                {"John", "johnnybravo@mail.com"}
        };
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accountsList = new ArrayList<>();
        for(String[] arr:accounts){
            accountsList.add(Arrays.asList(arr));
        }
        for(List<String> account:accountsMerge.accountsMerge(accountsList)){
            for(String name:account){
                System.out.print(name);
            }
        }
    }
}
