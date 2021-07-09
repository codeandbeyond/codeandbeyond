package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class LargestAlphabeticCharacter {
    public String largest(String str){
        if(str == null || str.length() == 0) return "-1";
        boolean[] loweCase = new boolean[26];
        boolean[] upperCase = new boolean[26];
        for(char c: str.toCharArray()){
            if(Character.isLowerCase(c)){
                loweCase[c-'a'] = true;
            }else{
                upperCase[c-'A'] = true;
            }
        }
        for(int i=25;i>=0;i--){
            if(loweCase[i] && upperCase[i]){
                return ""+(char)(i+'A');
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        LargestAlphabeticCharacter largestAlphabeticCharacter = new LargestAlphabeticCharacter();
       String res =  largestAlphabeticCharacter.largest("dAeB");
        System.out.println(res);
    }
}
