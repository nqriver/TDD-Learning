package pl.myexamples.tdd.palindromicnumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromicNumberTest {

    PalindromicNumber palindromicNumber = new PalindromicNumber();

    @Test
    public void shouldStateThatDigitIsPalindromic() {
        Assertions.assertTrue(palindromicNumber.test(0));
        Assertions.assertTrue(palindromicNumber.test(1));
    }

    @Test
    public void shouldCheckNonPalindromicNumbers() {
        Assertions.assertFalse(palindromicNumber.test(1212));
    }

    @Test public void shouldCheckNumberWithOddNumberOfDigits() {
        Assertions.assertTrue(palindromicNumber.test(1219121));
        Assertions.assertFalse(palindromicNumber.test(100));
    }

}