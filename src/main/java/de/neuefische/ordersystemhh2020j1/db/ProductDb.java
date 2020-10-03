package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;

import java.util.Collections;
import java.util.List;

public class ProductDb {

    private final List<Product> products = List.of(
            new Product("tomaten", "Tomaten"),
            new Product("eier", "Eier"),
            new Product("moehren", "Möhren")
    );

    public List<Product> list(){
        return Collections.unmodifiableList(products);
    }

}
