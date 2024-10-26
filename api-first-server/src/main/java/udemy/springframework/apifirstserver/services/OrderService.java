package udemy.springframework.apifirstserver.services;

import java.util.List;
import java.util.UUID;
import udemy.springframework.model.Order;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface OrderService {
    List<Order> listOrders();

    Order getOrderById(UUID orderId);
}