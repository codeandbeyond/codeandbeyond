package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class StringRotaionTwoPlaces {
    public static void main(String[] args) {
        String s1 = "amazon";
        String s2 = "onamaz";
        if (!checkRotationPossible(s1, s2))
            System.out.print(" Not ");
        System.out.println("Possible");
    }

    private static boolean checkRotationPossible(String s1, String s2) {
        String leftRotation = leftRotation(s2, s2.length());
        String rightRotation = rightRotate(s2, s2.length());
        return s1.equals(leftRotation) || s1.equals(rightRotation);
    }

    private static String rightRotate(String s2, int length) {
        return s2.substring(length - 2, length) + s2.substring(0, length - 2);
    }

    private static String leftRotation(String s2, int length) {
        return s2.substring(2, length) + s2.substring(0, 2);
    }

}
