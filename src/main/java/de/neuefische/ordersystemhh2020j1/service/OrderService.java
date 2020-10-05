package de.neuefische.ordersystemhh2020j1.service;

import de.neuefische.ordersystemhh2020j1.db.OrderDb;
import de.neuefische.ordersystemhh2020j1.db.ProductDb;
import de.neuefische.ordersystemhh2020j1.model.Order;

import java.util.List;
import java.util.UUID;

public class OrderService {

    private final OrderDb orderDb;
    private final ProductDb productDb;

    public OrderService(OrderDb orderDb, ProductDb productDb) {
        this.orderDb = orderDb;
        this.productDb = productDb;
    }

    public Order createOrder(List<String> products){
        for (String product : products) {
            if(productDb.get(product).isEmpty()){
                throw new IllegalArgumentException("product "+product+" not found!");
            }
        }

        String id = UUID.randomUUID().toString();
        Order order = new Order(id, products);
        this.orderDb.add(order);
        return order;
    }

    public List<Order> list() {
        return orderDb.list();
    }
}
