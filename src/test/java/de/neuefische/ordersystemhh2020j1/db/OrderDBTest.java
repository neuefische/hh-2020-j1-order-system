package de.neuefische.ordersystemhh2020j1.db;

import de.neuefische.ordersystemhh2020j1.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class OrderDBTest {

    @Test
    public void addShouldAddOrderToDB(){
        //GIVEN
        OrderDB db = new OrderDB();
        Order order1 = new Order("1", List.of("eier", "tomaten"));
        Order order2 = new Order("2", List.of("tomaten"));

        //WHEN
        db.add(order1);
        db.add(order2);
        List<Order> orders = db.list();

        //THEN
        assertThat(orders, containsInAnyOrder(order1,order2));
    }

}
