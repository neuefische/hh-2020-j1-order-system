package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void getExistingProductShouldReturnProduct() {
        //GIVEN
        ProductDb productDb = new ProductDb();

        //WHEN
        Optional<Product> product = productDb.get("eier");

        //THEN
        assertThat(product.get(), is(new Product("eier", "Eier")));

    }

    @Test
    public void getNotExistingProductShouldReturnEmptyOptional() {
        //GIVEN
        ProductDb productDb = new ProductDb();

        //WHEN
        Optional<Product> product = productDb.get("bananen");

        //THEN
        assertTrue(product.isEmpty());

    }
}
