package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.ArrayDeque;
import java.util.Queue;

public class Josephus {
    public static void main(String[] args) {
        int m=3;
        int n=7;
        josephus(m,n);
    }

    private static void josephus(int m, int n) {
        Queue queue=new ArrayDeque<Integer>();
        for(int i=0;i<n;i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            for(int i=0;i<m-1;i++){
                queue.add(queue.remove());
            }
            System.out.print(" "+queue.remove());
        }
    }
}
