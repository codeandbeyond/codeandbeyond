package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class BuildLowestNumber {
    public static void main(String[] args) {
        String str = "4325043";
        int n = 3;
      //  System.out.println(buildLowestNumber(str,n,""));
        System.out.println(buildLowest(str, n));
    }

    private static String buildLowest(String num, int k) {
        if (num.length() <= k)
            return "0";

        StringBuilder sb = new StringBuilder(num);

        /*We will iterate the number k times. In each iteration:
        1. Remove the digit for which the next digit is smaller.
        2. If we reach at the end than remove last digit.*/
        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        //remove leading 0's
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.delete(0, 1);

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }

    private static String buildLowestNumber(String num, int n,String result) {
        if (n == 0) {
            return result.concat(num);
        }
        if (num.length() <= n)
            return result;


        int minIndex = 0;
        for (int i = 1; i <= n; i++) {

            if (num.charAt(i) < num.charAt(minIndex)) {
                minIndex = i;

            }
        }
        result+=(num.charAt(minIndex));
        return buildLowestNumber(num.substring(minIndex+1),n-minIndex,result);

    }

}
