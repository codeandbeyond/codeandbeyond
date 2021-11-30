package home.practice.company.problems.preparation;

/**
 * Created by Ashok on 02-06-2020.
 */
public class MinimumStepsToReach {
    public static void main(String[] args) {
        System.out.println(" Minimum Steps to Reach End " + minmumSteps(0, 0, 11));
    }

    private static int minmumSteps(int source, int step, int dest) {
        if (Math.abs(source) > Math.abs(dest)) {
            return Integer.MAX_VALUE;
        }
        if (source == dest) {
            return step;
        }
        int pos = minmumSteps(source + step + 1, step + 1, dest);
        int neg = minmumSteps(source - step - 1, step + 1, dest);
        return Math.min(pos, neg);

    }
}
