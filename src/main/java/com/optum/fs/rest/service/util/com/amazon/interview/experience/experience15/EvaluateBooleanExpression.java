package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class EvaluateBooleanExpression {

    public static final char OR = 'B';
    public static final char AND = 'A';


    public static void main(String[] args) {
        String s = "1C1B1B0A0";
        StringBuffer sb = new StringBuffer(s);
        System.out.println(s + " = " + evaluate(sb));

        // Drive code

            int n = 4;
            System.out.println(getFirstSetBitPos(n));

    }
    public static int getFirstSetBitPos(int n)
    {
        return (int)((Math.log10(n & -n)) / Math.log10(2));
    }


    private static int evaluate(StringBuffer sb) {
        for (int i = 0; i < sb.length(); i = i + 2) {
            if ((i + 1) < sb.length() && (i + 2) < sb.length()) {
                if (sb.charAt(i + 1) == OR) {
                    if (sb.charAt(i) == '1' || sb.charAt(i + 2) == '1') {
                        sb.setCharAt(i + 2, '1');
                    } else {
                        sb.setCharAt(i + 2, '0');
                    }
                } else if (sb.charAt(i + 1) == AND) {
                    if (sb.charAt(i) == '0' || sb.charAt(i + 2) == '0') {
                        sb.setCharAt(i + 2, '0');
                    } else {
                        sb.setCharAt(i + 2, '1');
                    }
                } else {
                    if (sb.charAt(i + 2) == sb.charAt(i)) {
                        sb.setCharAt(i + 2, '0');
                    } else {
                        sb.setCharAt(i + 2, '1');
                    }

                }
            }
        }
        return sb.charAt(sb.length() - 1) - '0';
    }
}
