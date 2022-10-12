package com.cef.testTask.controller;

import com.cef.testTask.model.OrdersModel;
import com.cef.testTask.repository.OrdersRepository;
import com.cef.testTask.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersService ordersService;

    public OrdersController(OrdersRepository ordersRepository, OrdersService ordersService) {
        this.ordersRepository = ordersRepository;
        this.ordersService = ordersService;
    }

    @GetMapping("/addOrder")
    public String addOrderPage(Model model){
        model.addAttribute("addOrderRequest", new OrdersModel());
        return "add_order";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute OrdersModel ordersModel){
        OrdersModel addedOrder = ordersService.createOrder(ordersModel.getProduct(),
                ordersModel.getValue(), ordersModel.getCity());
        return addedOrder == null ? "error_page" : "redirect:/addOrder";
    }

    @GetMapping("/orders")
    public String orders(Model model){
        Iterable<OrdersModel> ordersModels = ordersRepository.findAllByOrderByIdAsc();
        model.addAttribute("orders", ordersModels);
        return "orders";
    }
}
