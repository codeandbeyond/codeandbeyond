package home.practice.company.problems.preparation;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Ashok on 04-06-2020.
 */
public class SortAccordingToAnotherArray {
    public static void main(String[] args) {
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};
        System.out.println("Sorted array is ");
        sortAccording(A1, A2);
    }

    private static void sortAccording(int[] a1, int[] a2) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int i : a1) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        for(int num:a2){
           Integer freq = countMap.get(num);
            if(freq!=null){
                for(int i=0;i<freq;i++){
                    System.out.print(num+" ");
                }
                countMap.remove(num);
            }
        }
        Set<Integer> remainingNumbers = countMap.keySet();
        for(Integer num:remainingNumbers){
            System.out.print(num+" ");
        }
    }
}
