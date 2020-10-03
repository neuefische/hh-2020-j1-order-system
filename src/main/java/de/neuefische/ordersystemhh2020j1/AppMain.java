package de.neuefische.ordersystemhh2020j1;

import de.neuefische.ordersystemhh2020j1.db.ProductDb;

public class AppMain {

    public static void main(String[] args) {
        ProductDb productDb = new ProductDb();
        System.out.println("Please select a product to order");
        productDb.list().forEach(System.out::println);

    }
}
