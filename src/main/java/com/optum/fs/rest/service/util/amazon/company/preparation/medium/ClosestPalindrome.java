package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long number = Long.parseLong(n);
        boolean isEvenDigits = n.length() % 2 == 0;
        if (number <= 10 || number % 10 == 0 && n.charAt(0)=='1' && Long.parseLong(n.substring(1)) == 0) {
            return "" + (number - 1);
        }

        if (number == 11 || number % 10 == 1 && n.charAt(0) == '1' && Long.parseLong(n.substring(1, len - 1)) == 0) {
            return "" + (number - 2);
        }

        if (allDigits9(n)) {
            return "" + (number + 2);
        }

        String palinDromeRoot = isEvenDigits ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);

        long palinDromeRootNum = Long.parseLong(palinDromeRoot);

        long equal = convertToPalindrome("" + (palinDromeRootNum), isEvenDigits);
        long equalDiff = Math.abs(number - equal);

        long bigger = convertToPalindrome("" + (palinDromeRootNum + 1), isEvenDigits);
        long diffBig = Math.abs(number - bigger);

        long smaller = convertToPalindrome("" + (palinDromeRootNum - 1), isEvenDigits);
        long diffSmall = Math.abs(number - smaller);

        long closest = diffBig < diffSmall ? bigger : smaller;
        long minDiff = Math.min(diffBig, diffSmall);

        if (0 != equalDiff) {
            if (minDiff == equalDiff) {
                closest = Math.min(closest, equal);
            } else if (equalDiff < minDiff) {
                closest = equal;
            }
        }
        return String.valueOf(closest);
    }

    private long convertToPalindrome(String s, boolean isEvenDigits) {
        StringBuilder reverse = new StringBuilder(s).reverse();
        String palindromeDigs = "";
        if (isEvenDigits) {
            palindromeDigs = s + reverse;
        } else {
            palindromeDigs = s + reverse.deleteCharAt(0).toString();
        }
        return Long.parseLong(palindromeDigs);
    }

    private boolean allDigits9(String s) {
        for (char c : s.toCharArray()) {
            if (c != '9') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String num1 = "500";
        String num2 = "123456";
        ClosestPalindrome closestPalindrome = new ClosestPalindrome();
        String ans = closestPalindrome.nearestPalindromic(num1);
        System.out.println(num1 + "-->" + ans);
        ans = closestPalindrome.nearestPalindromic(num2);
        System.out.println(num2 + "-->" + ans);
    }
}
