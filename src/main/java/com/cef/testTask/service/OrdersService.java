package com.cef.testTask.service;

import com.cef.testTask.model.OrdersModel;
import com.cef.testTask.model.UsersModel;
import com.cef.testTask.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public OrdersModel createOrder (String product, Integer value, String city) {
        if (product == null || value == null)
            return null;
        else {
            if (ordersRepository.findByProduct(product).isPresent()) {
                System.out.println("Duplicate product");
                return null;
            }
            OrdersModel ordersModel = new OrdersModel();
            ordersModel.setProduct(product);
            ordersModel.setValue(value);
            ordersModel.setCity(city);
            return ordersRepository.save(ordersModel);
        }
    }

    }
