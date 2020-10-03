package de.neuefische.ordersystemhh2020j1.service;

import de.neuefische.ordersystemhh2020j1.db.OrderDB;
import de.neuefische.ordersystemhh2020j1.db.ProductDb;
import de.neuefische.ordersystemhh2020j1.model.Order;

import java.util.List;
import java.util.UUID;

public class OrderService {

    private final ProductDb productDb;
    private final OrderDB orderDB;

    public OrderService(ProductDb productDb, OrderDB orderDB) {
        this.productDb = productDb;
        this.orderDB = orderDB;
    }

    public Order createOrder(List<String> productIds){
        for (String productId : productIds) {
            if(productDb.get(productId).isEmpty()){
                throw new IllegalArgumentException("Product with id "+ productId+ " not found");
            }
        }
        Order order = new Order(UUID.randomUUID().toString(), productIds);
        orderDB.add(order);
        return order;
    }

    public List<Order> listOrders() {
        return orderDB.list();
    }
}
