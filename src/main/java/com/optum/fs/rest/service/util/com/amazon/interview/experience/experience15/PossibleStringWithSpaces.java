package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class PossibleStringWithSpaces {
    public static void main(String[] args) {
        String string = "abc";
        printPossibleStrings(string);
    }

    private static void printPossibleStrings(String string) {
        int length = string.length();
        StringBuilder result = new StringBuilder();
        int totalResultSize = (int) Math.pow(2,length-1);
        for(int i=0;i<totalResultSize;i++){
            for(int j=0;j<length;j++){
                result.append(string.charAt(j));
                if((i & (1<<j) )>0){
                    result.append(" ");
                }
            }
            System.out.println(result+" ");
            result.delete(0,result.length());
        }
    }
}
