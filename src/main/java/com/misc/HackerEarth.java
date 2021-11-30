package com.misc;

public class HackerEarth {
    static {
        code(2);
    }

     static void code(int i) {
        System.out.println(i);
    }
    HackerEarth(){
        code(5);
    }
    static {
        code(4);
    }
    static {
        code(6);
    }

    static {
        new HackerEarth();
    }

    {
        code(8);
    }

    public static void main(String[] args) {

    }
}
