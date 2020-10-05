package de.neuefische.ordersystemhh2020j1.service;

import de.neuefische.ordersystemhh2020j1.db.OrderDb;
import de.neuefische.ordersystemhh2020j1.db.ProductDb;
import de.neuefische.ordersystemhh2020j1.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;


class OrderServiceTest {

    private final OrderDb orderDb = new OrderDb();
    private final ProductDb productDb = new ProductDb();
    private final OrderService orderService = new OrderService(orderDb, productDb);


    @Test
    public void createOrderShouldCreateANewOrderWithProducts() {
        //GIVEN
        List<String> products = List.of("tomate", "erbsen");
        //WHEN
        Order order = orderService.createOrder(products);

        //THEN
        Optional<Order> savedOrder = orderDb.get(order.getId());
        assertThat(order.getId(), notNullValue());
        assertThat(order.getProducts(), containsInAnyOrder("tomate", "erbsen"));
        assertThat(savedOrder.get(), is(order));
    }

    @Test
    public void listShouldReturnAllOrders() {
        //GIVEN
        orderDb.add(new Order("some-id", List.of("erbsen")));
        orderDb.add(new Order("other-id", List.of("erbsen", "tomate")));

        //WHEN
        List<Order> orders = orderService.list();

        //THEN
        assertThat(orders, containsInAnyOrder(
                new Order("some-id", List.of("erbsen")),
                new Order("other-id", List.of("erbsen", "tomate"))));
    }

    @Test
    public void createOrderShouldThrowIllegalArgumentExceptionWhenProductNotExists(){
        //GIVEN
        List<String> products = List.of("tomate", "erbsen", "flugzeug");

        //WHEN
        try {
            orderService.createOrder(products);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("product flugzeug not found!"));
        }

    }

}
