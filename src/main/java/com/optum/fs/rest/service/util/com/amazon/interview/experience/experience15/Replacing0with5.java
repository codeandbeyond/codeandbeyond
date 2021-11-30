package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class Replacing0with5 {


    public static void main(String[] args) {
        int number = 112;
        number = replace0with5(number);
        System.out.println(number);
    }

    private static int replace0with5(int number) {
        int result = 0;
        int decimalPlace = 1;
        while (number > 0) {
            int pop = number % 10;
            if ( pop == 0) {
                result = 5 * decimalPlace + result;
            }else{
                result = pop * decimalPlace + result;
            }
            number = number / 10;
            decimalPlace = decimalPlace * 10;
        }
        return result;
    }
}
