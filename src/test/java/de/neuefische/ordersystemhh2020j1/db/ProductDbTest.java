package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class ProductDbTest {

    @Test
    public void listShouldReturnAllProducts(){
        //GIVEN
        ProductDb productDb = new ProductDb();

        //WHEN
        List<Product> list = productDb.list();

        //THEN
        assertThat(list, containsInAnyOrder(
                new Product("tomate", "Tomate"),
                new Product("erbsen", "Erbsen")
        ));
    }

}
