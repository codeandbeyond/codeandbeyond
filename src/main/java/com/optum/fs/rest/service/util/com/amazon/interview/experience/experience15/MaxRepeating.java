package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class MaxRepeating {
    public static void main(String[] args) {

        int arr[] = {2, 3, 3, 5, 3, 2, 1, 2};
        int n = arr.length;
        int k=8;
        System.out.println("Maximum repeating element is: " +
                printMaxRepeatingAll(arr,n,k));
    }

    private static int maxRepeating(int[] arr, int n, int k) {

        for(int i=0;i<n;i++){
            arr[arr[i]%k]+=k;
        }
        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }

        /* Uncomment this code to get the original array back
        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k; */

        // Return index of the maximum element
        return result;
    }
    private static int printMaxRepeatingAll(int[] arr, int n, int k) {

        for(int i=0;i<n;i++){
            arr[arr[i]%k]+=k;
        }

        for(int i=0;i<n;i++){
            arr[i] = arr[i]/n;
        }
        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i]> max)
            {
                max = arr[i];

            }
        }
        for(int i=0;i<n;i++){
            if(arr[i] == max){
                System.out.println(" "+i);
            }
        }

        /* Uncomment this code to get the original array back
        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k; */

        // Return index of the maximum element
        return result;
    }
}
