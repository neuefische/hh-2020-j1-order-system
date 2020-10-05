package de.neuefische.ordersystemhh2020j1.service;

import de.neuefische.ordersystemhh2020j1.db.OrderDb;
import de.neuefische.ordersystemhh2020j1.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class OrderServiceTest {

    @Test
    public void createOrderShouldCreateANewOrderWithProducts() {
        //GIVEN
        List<String> products = List.of("tomate", "erbsen");
        OrderDb orderDb = new OrderDb();
        OrderService orderService = new OrderService(orderDb);

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
        OrderDb orderDb = new OrderDb();
        OrderService orderService = new OrderService(orderDb);
        orderDb.add(new Order("some-id", List.of("erbsen")));
        orderDb.add(new Order("other-id", List.of("erbsen", "tomate")));

        //WHEN
        List<Order> orders = orderService.list();

        //THEN
        assertThat(orders, containsInAnyOrder(
                new Order("some-id", List.of("erbsen")),
                new Order("other-id", List.of("erbsen", "tomate"))));
    }

}
