package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;


import java.util.Set;
import java.util.TreeSet;

public class PowerSet {
    static void printPowerSet(char[] set,
                              int set_size) {
        Set<String> unique = new TreeSet<String>();

        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
        long pow_set_size =
                (long) Math.pow(2, set_size);
        int counter, j;

        /*Run from counter 000..0 to
        111..1*/
        for (counter = 0; counter <
                pow_set_size; counter++) {
            String subString ="";
            for (j = 0; j < set_size; j++) {
                /* Check if jth bit in the
                counter is set If set then
                print jth element from set */
                if ((counter & (1 << j)) != 0)
                    subString = subString+set[j];
            }

            unique.add(subString+"|");
        }
        for (String subset:unique){
            String[] arr = subset.split("\\|");
            for(String string:arr){
                System.out.print(string);
            }
            System.out.println("");
        }
    }

    // Driver program to test printPowerSet
    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        printPowerSet(set, 3);
    }
}
