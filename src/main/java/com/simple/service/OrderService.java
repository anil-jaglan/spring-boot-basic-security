package com.simple.service;

import com.simple.domain.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Map<Integer, Order> orders = new HashMap<>();
    static {
        IntStream.range(1, 100).forEach(
                i -> orders.put(i, new Order(i, "Customer-" + i, "Address-" + i, 10 * i, 1 + i)));
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    public Collection<Order> getAllOrder() {
        return orders.values();
    }
}
