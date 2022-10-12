package com.cef.testTask.service;

import com.cef.testTask.dto.OrdersDto;
import com.cef.testTask.model.OrdersModel;
import com.cef.testTask.model.UsersModel;
import com.cef.testTask.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;


    public List<OrdersDto> getAllOrdersLocal () {
        return ordersRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private OrdersDto convertEntityToDto (OrdersModel ordersModel) {
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setProduct(ordersModel.getProduct());
        ordersDto.setValue(ordersModel.getValue());
        ordersDto.setCity(ordersModel.getCity());
        return ordersDto;
    }

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
