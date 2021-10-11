package pl.myexamples.tdd.palindromicnumbers;

import java.util.function.Predicate;

public class PalindromicNumber implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        int reversed_number = 0, n = number;
        while (n != 0) {
            reversed_number = reversed_number * 10 + n % 10;
            n /= 10;
        }
        return reversed_number == number;
    }
}

