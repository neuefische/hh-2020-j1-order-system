package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Order;

import java.util.*;

public class OrderDb {

    private final ArrayList<Order> orders = new ArrayList<>();

    public Order get(String id) {
        for (Order order : orders) {
            if(Objects.equals(id, order.getId())){
                return order;
            }
        }
        return null;
    }

    public void add(Order order) {
        orders.add(order);
    }

    public List<Order> list() {
        return Collections.unmodifiableList(orders);
    }
}
