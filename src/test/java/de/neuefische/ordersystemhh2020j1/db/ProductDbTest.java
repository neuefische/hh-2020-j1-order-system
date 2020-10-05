package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.*;

class ProductDbTest {

    private final ProductDb productDb = new ProductDb();

    @Test
    public void listShouldReturnAllProducts() {

        //WHEN
        List<Product> list = productDb.list();

        //THEN
        assertThat(list, containsInAnyOrder(
                new Product("tomate", "Tomate"),
                new Product("erbsen", "Erbsen")
        ));
    }

    @Test
    public void getShouldReturnProductWithId() {

        //WHEN
        Optional<Product> product = productDb.get("tomate");

        //THEN
        assertThat(product.get(), is(new Product("tomate", "Tomate")));
    }

    @Test
    public void getShouldReturnEmptyOptionalWhenIdNotFound() {

        //WHEN
        Optional<Product> product = productDb.get("flugzeug");

        //THEN
        assertThat(product.isEmpty(), is(true));
    }

}
