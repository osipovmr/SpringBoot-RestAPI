package com.cef.testTask.controller;

import com.cef.testTask.dto.OrderDto;
import com.cef.testTask.model.Order;
import com.cef.testTask.repository.OrderRepository;
import com.cef.testTask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/addOrder")
    public String addOrderPage(Model model){
        model.addAttribute("addOrderRequest", new Order());
        return "order_form";
    }

    @GetMapping("/ordersLocation")
    public @ResponseBody List<OrderDto> getOrdersLocal () {
        System.out.println(orderService.getAllOrdersLocal());
        return orderService.getAllOrdersLocal();
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute ("addOrderRequest") @Valid Order order, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "order_form";
        Order addedOrder = orderService.createOrder(order.getProduct().toLowerCase(),
                order.getValue(), order.getCity().trim());
        return addedOrder == null ? "error_page" : "redirect:/addOrder";
    }

    @GetMapping("/orders")
    public String orders(Model model){
        Iterable<Order> ordersModels = orderRepository.findAllByOrderByIdAsc();
        model.addAttribute("orders", ordersModels);
        return "orders";
    }
}
