package pl.myexamples.algorithms.findmisssing;

import java.util.Arrays;


public class MissingElementFinder {

    protected static int optimalFindMissing(int... array) {
        return findMissing(array);
    }

    protected static int greedyFindMissing(int... array) {
        if (array.length == 0) return 0;
        boolean [] filled = new boolean[array.length + 1];
        for (var value : array) {
            filled[value] = true;
        }
        for (int i = 0; i < filled.length - 1; i++) {
            if (!filled[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid input array");
    }


    protected static int findMissing(int... array) {

        if (array.length == 0) return 0;

        if (Arrays.stream(array).max().getAsInt() != array.length)
            throw new IllegalArgumentException("Invalid input array");

        int expectedTotalSum = array.length * (array.length + 1) / 2;

        int sum = 0;
        for (var val : array) {
            sum += val;
        }

        int element = expectedTotalSum - sum;
        if (element < 0) {
            throw new IllegalArgumentException("Invalid input array");
        }
        return element;
    }
}
