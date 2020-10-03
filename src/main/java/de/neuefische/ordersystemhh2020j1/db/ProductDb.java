package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductDb {

    private final List<Product> products = List.of(
            new Product("tomaten", "Tomaten"),
            new Product("eier", "Eier"),
            new Product("moehren", "Möhren")
    );

    public List<Product> list(){
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> get(String productId) {
        for (Product product : products) {
            if(productId.equals(product.getId())){
                return Optional.of(product);
            }
        }
         return Optional.empty();
    }
}
