package pl.myexamples.tdd.palindromicnumbers;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindPalindromicNumbersInRange {

    private static IntPredicate isPalindromic = number -> {
        int reversed_number = 0, n = number;
        while (n != 0) {
            reversed_number = reversed_number * 10 + n % 10;
            n /= 10;
        }
        return reversed_number == number;
    };


    public static List<Integer> findPalindromicNumbers(int lowerBound, int upperBound) {
        return IntStream.rangeClosed(lowerBound, upperBound)
                .filter(isPalindromic)
                .boxed()
                .toList();
    }
}
