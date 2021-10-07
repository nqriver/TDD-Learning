package pl.myprojects.tdd.basketmanager;

import pl.myprojects.tdd.basketmanager.domain.Basket;
import pl.myprojects.tdd.basketmanager.domain.Item;


public class BasketPrintTest {
    public static void main(String[] args) {
        Basket basket = new Basket();

        basket.add(new Item(13.4, "Hat"));
        basket.add(new Item(24.1, "Dress"));
        basket.add(new Item(24.1, "Dress"), 2);
        basket.add(new Item(12, "Lamp"), 3);
        basket.add(new Item(120, "Trampoline"), 1);
        basket.add(new Item(13.55, "Kettle"), 2);
        basket.add(new Item(15.25, "Pot"));
        basket.add(new Item(17.99, "Pot"));
        basket.add(new Item(4.90, "Collar"));

        basket.remove(new Item(24.1, "Dress"));
        System.out.println(basket);
    }
}
