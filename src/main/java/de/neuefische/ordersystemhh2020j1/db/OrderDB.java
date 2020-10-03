package de.neuefische.ordersystemhh2020j1.db;


import de.neuefische.ordersystemhh2020j1.model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDB {
    private final ArrayList<Order> orders = new ArrayList<>();

    public List<Order> list(){
        return Collections.unmodifiableList(orders);
    }

    public void add(Order order){
        this.orders.add(order);
    }
}
