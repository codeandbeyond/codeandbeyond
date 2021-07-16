class MergeSort {


        static void sort(Comparable[] array) {
            Comparable[] aux=new Comparable[array.length];
            sort(aux,array,0,array.length-1);
            show(array);

        }
    static void sortBU(Comparable[] array) {
        Comparable[] aux=new Comparable[array.length];
        sort(aux,array,0,array.length-1);
        show(array);

    }

    private static void sort(Comparable[] aux, Comparable[] array, int low, int high) {
            if(high<=low) return;
            int mid=low+(high-low)/2;
            sort(aux,array,low,mid);
            sort(aux,array,mid+1,high);
            merge(aux,array,low,mid,high);

    }
    private static void BU(int N,Comparable[] array,Comparable[] aux){
            for(int size=1;size<N;size=size+size){
                for(int lo=0;lo<N-size;lo=lo+size+size){
                    merge(aux,array,lo,lo+size-1,Math.min(lo+size+size-1,N-1));
                }
            }

    }

    private static void merge(Comparable[] aux, Comparable[] array, int low, int mid, int high) {
            int i=low;
            int j=mid+1;
        System.arraycopy(array, 0, aux, 0, high + 1);
            for (int k=low;k<=high;k++){
                if(i>mid)array[k]=aux[j++];
                else if(j>high)array[k]=aux[i++];
                else if(isLess(aux[i],aux[j]))array[k]=aux[i++];
                else array[k]=aux[j++];
            }
    }

    private static void show(Comparable[] array) {
            if (array instanceof Integer[]) {
                for (Integer i : (Integer[]) array) {
                    System.out.println(" " + i);
                }
            }
        }

    private static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
        }

}
