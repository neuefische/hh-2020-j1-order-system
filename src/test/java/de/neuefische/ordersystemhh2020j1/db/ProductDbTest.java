package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class ProductDbTest {

    @Test
    public void listProductsShouldReturnAllProducts() {
        //GIVEN
        ProductDb productDb = new ProductDb();

        //WHEN
        List<Product> products = productDb.list();

        //THEN
        assertThat(products, containsInAnyOrder(new Product("tomaten", "Tomaten"),
                new Product("eier", "Eier"),
                new Product("moehren", "Möhren")));
    }
}
