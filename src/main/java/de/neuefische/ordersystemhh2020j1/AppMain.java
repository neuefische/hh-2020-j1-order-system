package de.neuefische.ordersystemhh2020j1;

import de.neuefische.ordersystemhh2020j1.db.OrderDb;
import de.neuefische.ordersystemhh2020j1.db.ProductDb;
import de.neuefische.ordersystemhh2020j1.service.OrderService;

import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        ProductDb productDb = new ProductDb();
        OrderDb orderDb = new OrderDb();
        OrderService orderService = new OrderService(orderDb, productDb);

        System.out.println("All products");
        productDb.list().forEach(product -> System.out.println(product.getName()));

        System.out.println("Add order");
        orderService.createOrder(List.of("tomate"));

        System.out.println("All orders");
        orderService.list().forEach(System.out::println);
    }
}
