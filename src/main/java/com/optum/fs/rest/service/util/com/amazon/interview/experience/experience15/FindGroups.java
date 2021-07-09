package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class FindGroups {
    public static void main(String[] args) {
        FindGroups groups = new FindGroups();
        int arr[] = {3, 6, 7, 2, 9};
        int n = arr.length;
        System.out.println("Required number of groups are "
                + groups.findgroups(arr, n));
    }

    private int findgroups(int[] arr, int n) {
        int result = 0;
        int[] count = new int[3];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] % 3]++;
        }
        result = result + (count[0] * (count[0] - 1) / 2);
        result += count[1] * count[2];

        result += ((count[0] * (count[0] - 1) * (count[0] - 2)) / 6);

        result += ((count[1] * (count[1] - 1) * (count[1] - 2)) / 6);

        result += ((count[2] * (count[2] - 1) * (count[2] - 2)) / 6);

        result += count[0] * count[1] * count[2];

        return result;

    }
}
