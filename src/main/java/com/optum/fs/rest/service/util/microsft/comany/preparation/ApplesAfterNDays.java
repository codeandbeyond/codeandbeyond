package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.PriorityQueue;

public class ApplesAfterNDays {
    public int eatenApples(int[] apples, int[] days) {
        int appleCount = 0;
        PriorityQueue<int[]> appleStorage = new PriorityQueue<>((a, b)->(a[0]-b[0]));
        for(int i=0;i<apples.length || !appleStorage.isEmpty();i++){
            if(i<apples.length){
                appleStorage.offer(new int[]{i+days[i],apples[i]});
            }

            while(!appleStorage.isEmpty() && (appleStorage.peek()[0]<=i || appleStorage.peek()[1]<=0)){
                appleStorage.poll();
            }

            if(!appleStorage.isEmpty()){
                appleCount++;
                appleStorage.peek()[1]--;
            }
        }
        return appleCount;
    }
}
