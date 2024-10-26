package udemy.springframework.apifirstserver.controllers;

import static udemy.springframework.apifirstserver.controllers.OrderController.BASE_URL;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import udemy.springframework.apifirstserver.services.OrderService;
import udemy.springframework.model.Order;

/**
 * Created by jt, Spring Framework Guru.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class OrderController {

    public static final String BASE_URL = "/v1/orders";

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> listOrders(){
        return ResponseEntity.ok(orderService.listOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getProductById(@PathVariable("orderId") UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}