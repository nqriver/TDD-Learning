package pl.myprojects.tdd.basketmanager.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    protected static final String ITEM_ORDER_FORMAT = "%s (%.2f x %d = %.2f)";

    private final Map<Item, Integer> order = new TreeMap<>();

    public void add(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(String.format("Illegal quantity: %d", quantity));
        }
        if (order.containsKey(item)) {
            quantity += order.get(item);
        }
        order.put(item, quantity);
    }

    public void add(Item item) {
        add(item, 1);
    }

    public void remove(Item item, int quantity) {
        if (!order.containsKey(item)) {
            throw new IllegalArgumentException("There is no such item in basket");
        }
        var elementsLeft = order.get(item) - quantity;
        if (elementsLeft == 0) {
            order.remove(item);
        }
        else if (quantity <= 0 || elementsLeft < 0) {
            throw new IllegalArgumentException(String.format("Cannot remove %d quantity of item %s",
                    quantity, item.getName()));
        }
        else {
            order.put(item, elementsLeft);
        }
    }

    public void remove(Item item) {
        remove(item, 1);
    }

    public double getTotalOrderValue() {
        double total = 0;
        for (var item : order.entrySet()) {
            total = total + item.getValue() * item.getKey().getPrice();
        }
        return total;
    }

    public double getTotalItemValue(Item item) {
        return item.getPrice() * order.get(item);
    }

    public int getItemQuantity(Item item) {
        return order.get(item);
    }

    public Map<Item, Integer> getOrder() {
        return Collections.unmodifiableMap(order);
    }

    @Override
    public String toString() {
        StringBuilder orderRepresentation = new StringBuilder();

        for (var itemOrder : order.entrySet()) {
            var item = itemOrder.getKey();
            var quantity = itemOrder.getValue();
            String itemAsString = String.format(ITEM_ORDER_FORMAT,
                    item.getName(),
                    item.getPrice(),
                    quantity,
                    getTotalItemValue(item)
            );
            orderRepresentation.append(itemAsString);
            orderRepresentation.append(System.lineSeparator());
        }
        orderRepresentation.append(String.format("Total: %.2f", getTotalOrderValue()));
        return orderRepresentation.toString();
    }
}
