package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.LinkedHashMap;
import java.util.Map;

public class RunLeangthEncoding {
    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxywww";
        printRLE(str);
    }

    private static void printRLE(String str) {
        for(int i=0;i<str.length();i++){
            int count =1;
            while(i<str.length()-1 && (str.charAt(i) ==str.charAt(i+1))) {
                i++;
                count++;
            }
            System.out.print(str.charAt(i));
            System.out.print(count);
        }
    }

}
