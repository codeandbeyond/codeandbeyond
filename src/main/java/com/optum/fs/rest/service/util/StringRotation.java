package com.optum.fs.rest.service.util;

public class StringRotation {
    public static void main(String[] args) {
        String str = "abcd";
        int leftShifts = 1;
        int rightShifts = 2;
       String leftShift =  getShiftedString(str,leftShifts,rightShifts);
        System.out.println(leftShift);
    }

    private static String getShiftedString(String str, int leftShifts, int rightShifts) {
        int totalShifts = Math.abs(leftShifts-rightShifts)% str.length();
        return str.substring(totalShifts)+str.substring(0,totalShifts);

    }

}
