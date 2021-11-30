package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class IntegerToRoman {
    private static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public static void main(String[] args) {
    IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(68));
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< values.length && num > 0 ;i++){
            while(num >= values[i]){
                num = num-values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
