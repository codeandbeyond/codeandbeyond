package com.optum.fs.rest.service.util.data.structures;

public class MaxPQImplementation {
    public static void main(String[] args) {
        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(10);

        integerMaxPQ.insert(23);
        integerMaxPQ.insert(27);
        integerMaxPQ.insert(4);
        integerMaxPQ.insert(3);
        integerMaxPQ.insert(10);
        integerMaxPQ.insert(11);
        integerMaxPQ.insert(20);

        System.out.println(integerMaxPQ.removeMax());
    }
}
