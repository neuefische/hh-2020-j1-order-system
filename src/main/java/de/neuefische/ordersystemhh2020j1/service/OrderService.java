package de.neuefische.ordersystemhh2020j1.service;

import de.neuefische.ordersystemhh2020j1.db.OrderDb;
import de.neuefische.ordersystemhh2020j1.model.Order;

import java.util.List;
import java.util.UUID;

public class OrderService {

    private final OrderDb orderDb;

    public OrderService(OrderDb orderDb) {
        this.orderDb = orderDb;
    }

    public Order createOrder(List<String> products){
        String id = UUID.randomUUID().toString();
        Order order = new Order(id, products);
        this.orderDb.add(order);
        return order;
    }

    public List<Order> list() {
        return orderDb.list();
    }
}
