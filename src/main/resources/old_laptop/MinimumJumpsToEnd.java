package home.practice.company.problems.preparation;

/**
 * Created by Ashok on 01-06-2020.
 */
public class MinimumJumpsToEnd {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        System.out.println(" Can jump to end?? "+ canJump(arr));;
    }

    private static boolean canJump(int[] arr) {
        int lastGoodPosition = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i + arr[i] >= lastGoodPosition) {
                lastGoodPosition = i;
            }
        }
        return lastGoodPosition == 0;
    }
}
