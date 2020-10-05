package de.neuefische.ordersystemhh2020j1;

import de.neuefische.ordersystemhh2020j1.db.ProductDb;

public class AppMain {

    public static void main(String[] args) {
        ProductDb productDb = new ProductDb();

        System.out.println("All products");
        productDb.list().forEach(product -> System.out.println(product.getName()));
    }
}
