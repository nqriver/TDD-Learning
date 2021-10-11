package pl.myexamples.tdd.palindromicnumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pl.myexamples.tdd.palindromicnumbers.FindPalindromicNumbersInRange.findPalindromicNumbers;


class FindPalindromicNumbersInRangeTest {

    @Test
    public void shouldFindPalindromicNumberInOneElementRange() {
        var list = findPalindromicNumbers(1, 1);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void shouldFindPalindromicNumbersInRange() {
        var expectedList = List.of(0,1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99);
        assertEquals(expectedList, findPalindromicNumbers(0, 100));
    }

    @Test
    public void shouldNotFindPalindromicNumbersInNonPalindromicRange() {
        assertTrue(findPalindromicNumbers(1002, 1110).isEmpty());
    }

}