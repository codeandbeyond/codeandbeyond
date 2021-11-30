package com.misc;

public class Selection {

   public static void sort(Integer[] array){
       int N=array.length;
       int min;
       for(int i=0;i<N;i++){
           min=i;
           for(int j=i+1;j<N;j++){
               if(isLess(array[j],array[min]))
                   min=j;
           }
           exchange(array,i,min);
       }
       show(array);

   }

    private static void show(Integer[] array) {
       for(Integer i:array){
           System.out.println(" "+i);
       }
    }

    public static void exchange(Comparable arr[],int i ,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static boolean isLess(Comparable v ,Comparable w){
       return v.compareTo(w)<0;
    }

}


