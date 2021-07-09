package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class ExcelToTitle {
    public static void main(String[] args) {
        printString(26);
        printString(51);
        printString(52);
        printString(80);
        printString(676);
        printString(702);
        printString(705);
    }

    private static void printString(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            int rem = columnNumber % 26;

            if (rem == 0) {
                sb.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            } else {
                sb.append((char) ((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }
        System.out.println(sb.reverse());
    }
}
