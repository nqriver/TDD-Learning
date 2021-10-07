package pl.myprojects.tdd.basketmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.myprojects.tdd.basketmanager.domain.Basket;
import pl.myprojects.tdd.basketmanager.domain.Item;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasketTest {
    private Basket basket;
    private Item puzzles;

    @BeforeEach
    public void setup() {
        puzzles = new Item(12, "puzzles");
        basket = new Basket();
    }

    @Test
    public void shouldAllowToAddItemToBasket() {
        basket.add(puzzles);

        Map<Item, Integer> expected = new HashMap<>();
        expected.put(new Item(12, "puzzles"), 1);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldAllowToAddTheSameItemTwice() {
        basket.add(puzzles);
        basket.add(puzzles);

        Map<Item, Integer> expected = new HashMap<>();
        expected.put(new Item(12, "puzzles"), 2);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldAllowToAddQuantityOfItem() {
        basket.add(puzzles, 10);
        basket.add(puzzles);
        basket.add(puzzles);

        Map<Item, Integer> expected = new HashMap<>();
        expected.put(new Item(12, "puzzles"), 12);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldAllowToAddOneItemExplicitly() {
        basket.add(puzzles, 1);
        Map<Item, Integer> expected = new HashMap<>();
        expected.put(new Item(12, "puzzles"), 1);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldNotAllowToAddZeroItems() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(puzzles, 0));
    }

    @Test
    public void shouldNotAllowToAddNegativeQuantityOfItems() {
        assertThrows(IllegalArgumentException.class, () -> basket.add(puzzles, -2));
    }

    @Test
    public void shouldRemoveItemFromBasket() {
        basket.add(puzzles, 3);
        basket.remove(puzzles);

        Map<Item, Integer> expected = new HashMap<>();
        expected.put(puzzles, 2);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldRemoveSeveralItems() {
        basket.add(puzzles, 5);
        basket.remove(puzzles, 4);

        Map<Item, Integer> expected = new HashMap<>();
        expected.put(puzzles, 1);

        assertEquals(expected, basket.getOrder());
    }

    @Test
    public void shouldNotRemoveNonexistentItem() {
        assertThrows(IllegalArgumentException.class, () -> basket.remove(puzzles));
    }


    @Test
    public void shouldComputeOrderValue() {
        var carpet = new Item(31.2, "carpet");
        basket.add(carpet, 4);
        basket.add(puzzles, 2);

        var expectedTotalValue = carpet.getPrice() * 4 + puzzles.getPrice() * 2;

        assertEquals(expectedTotalValue, basket.getTotalOrderValue());
    }


    @Test
    public void shouldComputeSpecificItemTotalValue() {
        var carpet = new Item(31.2, "carpet");
        basket.add(carpet, 8);
        basket.add(puzzles, 12);

        var expectedTotalCarpetValue = carpet.getPrice() * 8;

        assertEquals(expectedTotalCarpetValue, basket.getTotalItemValue(carpet));
    }

}