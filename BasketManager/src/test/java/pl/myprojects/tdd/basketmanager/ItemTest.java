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
    public void shouldntCreateItemWithNegativePrize() {
        assertThrows(IllegalArgumentException.class, () -> new Item(-1, "tomato"));
    }

}