package com.cef.testTask.repository;

import com.cef.testTask.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findByProduct(String product);
    List<Order> findAllByOrderByIdAsc();
    }
