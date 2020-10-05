package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OrderDbTest {

    @Test
    public void addOrderShouldSaveOrderToDb(){
        //GIVEN
        OrderDb orderDb = new OrderDb();
        Order orderToSave = new Order(
                "some-id",
                List.of("product-1", "product-2")
        );
        //WHEN
        orderDb.add(orderToSave);

        //THEN
        Optional<Order> order = orderDb.get("some-id");
        assertThat(order.get(), is(new Order(
                "some-id",
                List.of("product-1", "product-2")
        )));
    }

    @Test
    public void listShouldReturnAllOrders() {
        //GIVEN
        OrderDb orderDb = new OrderDb();
        orderDb.add(new Order("some-id", List.of("erbsen")));
        orderDb.add(new Order("other-id", List.of("erbsen", "tomate")));

        //WHEN
        List<Order> orders = orderDb.list();

        //THEN
        assertThat(orders, containsInAnyOrder(
                new Order("some-id", List.of("erbsen")),
                new Order("other-id", List.of("erbsen", "tomate"))));
    }

    @Test
    public void getNotExistingIdShouldReturnEmptyOptional(){
        //GIVEN
        OrderDb orderDb = new OrderDb();

        //WHEN
        Optional<Order> order = orderDb.get("unknown-id");

        //THEN
        assertThat(order.isEmpty(), is(true));
    }

}
