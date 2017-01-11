package week1;

import java.util.Arrays;

/**
 * Created by lorenamesa on 12/13/16.
 */
public class BinarySearch {

    public static boolean recursive(int[] input, int valueToFind) {
        if (input.length == 0) {
            return false;
        }

        int mid = input.length / 2;
        if (input[mid] == valueToFind) {
            return true;
        } else if (input[mid] > valueToFind) {
            int[] smallerInput = Arrays.copyOfRange(input, 0, mid);
            return recursive(smallerInput, valueToFind);
        } else if (input[mid] < valueToFind) {
            int[] smallerInput = Arrays.copyOfRange(input, mid+1, input.length);
            return recursive(smallerInput, valueToFind);
        }

        return false;
    }

    public static boolean iterative(int[] input, int valueToFind) {
        int low = 0;
        int high = input.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (valueToFind > input[mid]) {
                high = mid - 1;
            } else if (input[mid] < valueToFind) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Recursive solution that uses ints, rather than copying arrays, to find
     * the index of the value in the array. If return -1, the value not in array.
     */
    public static int find(int[] input, int valueToFind) {
       return search(input, valueToFind, 0, input.length-1);
    }

    /**
     * Key here is to mutate the index pointers rather than the array itself.
     */
    private static int search(int[] input, int valueToFind, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (high + low) / 2;
        if (input[mid] > valueToFind) {
            return search(input, valueToFind, low, mid - 1);
        } else if (input[mid] < valueToFind) {
            return search(input, valueToFind, mid+1, high);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {
        int[] ex = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(recursive(ex, 10) == false);
        System.out.println(recursive(ex, 9) == false);
        System.out.println(recursive(ex, 8) == true);
        System.out.println(recursive(ex, 2) == true);

        int[] ex2 = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(recursive(ex2, 9) == false);
        System.out.println(recursive(ex2, 8) == false);
        System.out.println(recursive(ex2, 2) == true);
    }
}
