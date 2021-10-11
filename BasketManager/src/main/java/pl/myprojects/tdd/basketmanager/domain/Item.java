package pl.myprojects.tdd.basketmanager.domain;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private double price;
    private String name;

    public Item(double price, String name) {
        if (price < 0) {
            throw new IllegalArgumentException("Price should be positive");
        }
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }


    @Override
    public int compareTo(Item o) {
        if (o == null) {
            return 1;
        }
        int comparison = this.name.compareTo(o.name);
        if (comparison != 0) {
            return comparison;
        }
        return Double.compare(this.price, o.price);
    }
}
