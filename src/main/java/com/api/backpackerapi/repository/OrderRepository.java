package com.api.backpackerapi.repository;

import com.api.backpackerapi.domain.Order;
import java.util.List;

public interface OrderRepository{
    Order save(Order order);
    List<Order> findAll();
}