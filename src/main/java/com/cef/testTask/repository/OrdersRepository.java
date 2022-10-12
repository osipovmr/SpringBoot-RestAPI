package com.cef.testTask.repository;

import com.cef.testTask.model.OrdersModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<OrdersModel, Integer> {

    Optional<OrdersModel> findByProduct(String product);
    List<OrdersModel> findAllByOrderByIdAsc();
    }
