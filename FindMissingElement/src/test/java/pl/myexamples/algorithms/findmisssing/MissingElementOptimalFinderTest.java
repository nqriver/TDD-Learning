package pl.myexamples.algorithms.findmisssing;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class MissingElementOptimalFinderTest {

    @Test
    void shouldFindMissingElement() {
        assertThat(MissingElementFinder.optimalFindMissing(0, 1, 2, 3, 5), equalTo(4));
        assertThat(MissingElementFinder.optimalFindMissing(0, 2, 3, 4, 5, 6), equalTo(1));
        assertThat(MissingElementFinder.optimalFindMissing( 1, 4, 5, 6, 2, 3), equalTo(0));
    }

    @Test
    void shouldFindMissingElementInSingleElementArray() {
        assertThat(MissingElementFinder.optimalFindMissing(1), equalTo(0));
    }

    @Test
    void shouldFindMissingElementInEmptyArray() {
        assertThat(MissingElementFinder.optimalFindMissing(), equalTo(0));
    }

    @Test
    void shouldThrowIfNoneIsMissing() {
        assertThrows(IllegalArgumentException.class, () -> MissingElementFinder.optimalFindMissing(0,1,2, 3 ,4, 5));
        assertThrows(IllegalArgumentException.class, () -> MissingElementFinder.optimalFindMissing(0));
    }
}

