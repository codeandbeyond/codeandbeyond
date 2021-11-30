package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class NextGreatestPalindrome {
    public static void main(String[] args) {
        NextGreatestPalindrome nextGreatestPalindrome = new NextGreatestPalindrome();
        int num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        nextGreatestPalindrome.generateNextPalindrome(num, num.length);
    }

    private void generateNextPalindrome(int[] num, int length) {
        if (allNines(num)) {
            System.out.print("1");
            for (int i = 0; i < length - 1; i++) {
                System.out.print("0");
            }
            System.out.print("1");

        } else {
            generateNextPalindromeOther(num, length);
            printPalindrome(num);

        }
    }

    private void printPalindrome(int[] num) {
        for (int digit : num) {
            System.out.print(digit);
        }
    }

    private void generateNextPalindromeOther(int[] num, int length) {
        int carry = 1;
        int mid = length / 2;
        int i = mid - 1;
        int j = length % 2 == 0 ? mid : mid + 1;
        boolean leftSmaller = false;

        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }
        if (i < 0 || num[i] < num[j]) leftSmaller = true;

        while (i >= 0 && j < length) {
            num[j++] = num[i--];
        }
        if (leftSmaller) {
            if (length % 2 != 0) {
                num[mid] += carry;
                carry = num[mid] / 10;
                num[mid] = num[mid] % 10;
            }
            i = mid - 1;
            j = length % 2 == 0 ? mid : mid + 1;

            while (i >= 0 && carry > 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] = num[i] % 10;
                num[j] = num[i];
                j++;
                i--;
            }


        }
    }

    private boolean allNines(int[] num) {
        for (int number : num) {
            if (number != 9) {
                return false;
            }
        }
        return true;
    }
}
