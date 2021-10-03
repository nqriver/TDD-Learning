package pl.myexamples.algorithms.findmisssing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class MissingElementGreedyFinderTest {

    @Test
    void shouldFindMissingElementGreedy() {
        assertThat(MissingElementFinder.greedyFindMissing(0, 1, 2, 3, 5), equalTo(4));
        assertThat(MissingElementFinder.greedyFindMissing(0, 2, 3, 4, 5, 6), equalTo(1));
        assertThat(MissingElementFinder.greedyFindMissing( 1, 2, 3, 4, 5, 6), equalTo(0));
    }

    @Test
    void shouldFindMissingElementInSingleElementArray() {
        assertThat(MissingElementFinder.greedyFindMissing(1), equalTo(0));
    }

    @Test
    void shouldFindMissingElementInEmptyArray() {
        assertThat(MissingElementFinder.greedyFindMissing(), equalTo(0));
    }

    @Test
    void shouldThrowIfNoneIsMissing() {
        assertThrows(IllegalArgumentException.class, () -> MissingElementFinder.greedyFindMissing(0,1,2));
        assertThrows(IllegalArgumentException.class, () -> MissingElementFinder.greedyFindMissing(0));
    }
}

