package com.api.backpackerapi.repository;

import com.api.backpackerapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataOrderRepository extends JpaRepository<Order, Long>, OrderRepository {
}