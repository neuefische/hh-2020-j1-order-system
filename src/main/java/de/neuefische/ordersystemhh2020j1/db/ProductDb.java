package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;

import java.util.List;

public class ProductDb {

    private final List<Product> products = List.of(new Product("tomate", "Tomate"),
            new Product("erbsen", "Erbsen"));

    public List<Product> list() {
        return products;
    }

}
