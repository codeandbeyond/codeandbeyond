package com.optum.fs.rest.service.util.twilio.company.preparation;

import java.util.*;

public class MapingPhoneNumbers {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
        map.put('A', '2');
        map.put('B', '2');
        map.put('C', '2');
        map.put('D', '3');
        map.put('E', '3');
        map.put('F', '3');
        map.put('G', '4');
        map.put('H', '4');
        map.put('I', '4');
        map.put('J', '5');
        map.put('K', '5');
        map.put('L', '5');
        map.put('M', '6');
        map.put('N', '6');
        map.put('O', '6');
        map.put('P', '7');
        map.put('Q', '7');
        map.put('R', '7');
        map.put('S', '7');
        map.put('T', '8');
        map.put('U', '8');
        map.put('V', '8');
        map.put('W', '9');
        map.put('X', '9');
        map.put('Y', '9');
        map.put('Z', '9');
        List<String> name = Arrays.asList("JAZZ", "ZIZZ",
                "BUZZ",
                "FUZZ",
                "BAZZ",
                "FIZZ",
                "HAJJ",
                "JUJU",
                "QUIZ",
                "JEEZ",
                "RAZZ",
                "TIZZ",
                "JEUX",
                "JINX",
                "JACK",
                "JOCK",
                "JUMP");
        List<String> nameToNum = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            String curr = name.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < curr.length(); j++) {
                sb.append(map.get(curr.charAt(j)));
            }
            nameToNum.add(sb.toString());
        }
        List<String> numbers = Arrays.asList("+17474824380"
                , "+14157088956", "+919810155555", "+15109926333", "+1415123456");
        List<List<String>> out = new ArrayList<>();

        for (int i = 0; i < nameToNum.size(); i++) {
            out.add(findMatch(nameToNum.get(i), numbers));
        }

        List<String> solutions = new ArrayList<>();

        for (int i = 0; i < out.size(); i++) {
            List<String> res = out.get(i);
            for (String str : res) {
                solutions.add(str);
                System.out.print(" " + str);
            }
            System.out.println();
        }
        Collections.sort(solutions);
        System.out.println(solutions
        );

    }

    public static List<String> findMatch(String find, List<String> numbers) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).contains(find)) {
                result.add(numbers.get(i));
            }
        }
        List<String> output = new ArrayList<>(result);
        Collections.sort(output);
        return output;
    }

}
