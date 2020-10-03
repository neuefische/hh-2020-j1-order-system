package de.neuefische.ordersystemhh2020j1;

import de.neuefische.ordersystemhh2020j1.db.OrderDB;
import de.neuefische.ordersystemhh2020j1.db.ProductDb;
import de.neuefische.ordersystemhh2020j1.service.OrderService;

import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        ProductDb productDb = new ProductDb();
        System.out.println("Please select a product to order");
        productDb.list().forEach(System.out::println);

        OrderDB orderDB = new OrderDB();
        OrderService orderService = new OrderService(productDb, orderDB);

        System.out.println("Order products");
        orderService.createOrder(List.of("eier", "moehren"));
        orderService.createOrder(List.of("moehren"));

        orderService.listOrders().forEach(System.out::println);

    }
}
