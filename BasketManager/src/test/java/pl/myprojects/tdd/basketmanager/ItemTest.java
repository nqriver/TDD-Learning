package pl.myprojects.tdd.basketmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    public void shouldCreateNewItem() {
        Item item = new Item(12, "soap");
        assertNotNull(item);
    }

    @Test
    public void shouldntCreateItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Item(-1, "tomato"));
    }

    @Test
    public void itemsWithSameNameAndPriceShouldBeEqual() {
        assertEquals(new Item(12, "item"), new Item(12, "item"));
    }

    @Test
    public void itemsWithDifferentNamesShouldntBeEqual() {
        assertNotEquals(new Item(12, "item1"), new Item(12, "item"));
    }

    @Test
    public void itemsWIthDifferentPricesShouldntBeEqual() {
        assertNotEquals(new Item(1.2, "item"), new Item(12, "item"));
    }

    @Test
    public void itemsWithDifferentPriceAndTheSameNameShouldBeOrdered() {
        assertEquals(-1, new Item(0.1, "item1").compareTo(new Item(0.2, "item1")));
        assertEquals(1, new Item(4.4, "item1").compareTo(new Item(0.2, "item1")));
    }

    @Test
    public void itemsWithDifferentNamesShouldBeOrdered() {
        assert(new Item(10, "pineapple").compareTo(new Item(10, "apple")) > 0);
        assert(new Item(10, "carbon").compareTo(new Item(10, "gold")) < 0);
    }




}