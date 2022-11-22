package com.cef.testTask.service;

import com.cef.testTask.dto.OrderDto;
import com.cef.testTask.model.Order;
import com.cef.testTask.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public List<OrderDto> getAllOrdersLocal () {
        return orderRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private OrderDto convertEntityToDto (Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setProduct(order.getProduct());
        orderDto.setValue(order.getValue());
        orderDto.setCity(order.getCity());
        return orderDto;
    }

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder (String product, Integer value, String city) {
        if (product == null || value == null)
            return null;
        else {
            if (orderRepository.findByProduct(product).isPresent()) {
                System.out.println("Duplicate product");
                return null;
            }
            Order order = new Order();
            order.setProduct(product);
            order.setValue(value);
            order.setCity(city);
            return orderRepository.save(order);
        }
    }

    }
