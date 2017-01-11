package week1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by lorenamesa on 12/13/16.
 */
public class ThreeSum {

    public static int count(int[] digits) {

        int valueToReach = 0;
        int count = 0;
        final int size = digits.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (digits[i] + digits[j] + digits[k] == valueToReach) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int binarySearchCount(int[] digits) {
        // step 1: sort
        // step 2: binary search to find pairs
    }

    public static void main(String[] args) {
        int[] arg = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(ThreeSum.count(arg));
        double time = stopwatch.elapsedTime();
        System.out.println("Time to compute: " + time);
    }
}
