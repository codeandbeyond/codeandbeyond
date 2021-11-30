package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class BinaryNumberRepresentation {
    public static void main(String[] args) {
        binary(7);
    }

    private static void binary(int num) {
        if (num > 1)
            binary(num / 2);
        System.out.print(" " + num % 2);
    }
}
