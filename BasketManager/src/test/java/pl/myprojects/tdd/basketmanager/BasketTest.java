package pl.myprojects.tdd.basketmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

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






}