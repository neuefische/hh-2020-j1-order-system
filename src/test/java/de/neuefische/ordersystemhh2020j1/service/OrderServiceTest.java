package de.neuefische.ordersystemhh2020j1.service;

import de.neuefische.ordersystemhh2020j1.db.OrderDB;
import de.neuefische.ordersystemhh2020j1.db.ProductDb;
import de.neuefische.ordersystemhh2020j1.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    public void createOrderShouldAddANewOrderToTheDatabase() {
        //GIVEN
        ProductDb productDb = new ProductDb();
        OrderDB orderDB = new OrderDB();
        OrderService orderService = new OrderService(productDb, orderDB);

        //WHEN
        Order order = orderService.createOrder(List.of("eier", "tomaten"));

        //THEN
        assertFalse(order.getId().isBlank());
        assertThat(orderDB.list(), containsInAnyOrder(order));
        assertThat(order.getProducts(), containsInAnyOrder("eier", "tomaten"));

    }

    @Test
    public void createOrderShouldThrowExceptionWhenProductNotExists() {
        //GIVEN
        ProductDb productDb = new ProductDb();
        OrderDB orderDB = new OrderDB();
        OrderService orderService = new OrderService(productDb, orderDB);

        //WHEN
        try {
            orderService.createOrder(List.of("eier", "other", "tomaten"));
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Product with id other not found"));
            assertTrue(orderDB.list().isEmpty());
        }
    }


    @Test
    public void listShouldReturnAllOrders() {
        //GIVEN
        ProductDb productDb = new ProductDb();
        OrderDB orderDB = new OrderDB();
        orderDB.add(new Order("1", List.of("eier", "tomaten")));
        orderDB.add(new Order("2", List.of("tomaten")));
        OrderService orderService = new OrderService(productDb, orderDB);

        //WHEN
        List<Order> orders = orderService.listOrders();

        //THEN

        assertThat(orders, containsInAnyOrder(new Order("1", List.of("eier", "tomaten")),new Order("2", List.of("tomaten"))));

    }
}
