package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void getShouldReturnProductWithId(){
        //GIVEN
        ProductDb productDb = new ProductDb();

        //WHEN
        Optional<Product> product = productDb.get("tomate");

        //THEN
        assertThat(product.get(), is(new Product("tomate", "Tomate")));
    }

    @Test
    public void getShouldReturnEmptyOptionalWhenIdNotFound(){
        //GIVEN
        ProductDb productDb = new ProductDb();

        //WHEN
        Optional<Product> product = productDb.get("flugzeug");

        //THEN
        assertThat(product.isEmpty(), is(true));
    }

}
