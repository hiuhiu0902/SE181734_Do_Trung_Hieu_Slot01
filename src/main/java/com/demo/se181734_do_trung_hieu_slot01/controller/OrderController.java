package com.demo.se181734_do_trung_hieu_slot01.controller;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Order;
import com.demo.se181734_do_trung_hieu_slot01.pojo.OrderDetail;
import com.demo.se181734_do_trung_hieu_slot01.service.OrderService;
import com.demo.se181734_do_trung_hieu_slot01.service.OrderDetailService;
import com.demo.se181734_do_trung_hieu_slot01.service.OrchidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrchidService orchidService;

    @GetMapping
    public String viewOrders(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/create")
    public String createOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("orchids", orchidService.findAll());
        return "order/create";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order, @RequestParam List<Integer> orchidIds, @RequestParam List<Integer> quantities) {
        orderService.save(order);

        for (int i = 0; i < orchidIds.size(); i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setOrchid(orchidService.findById(orchidIds.get(i)));
            orderDetail.setQuantity(quantities.get(i));
            orderDetail.setPrice(orderDetail.getOrchid().getPrice());
            orderDetailService.save(orderDetail);
        }
        return "redirect:/orders/view/" + order.getId();
    }

    @GetMapping("/view/{orderId}")
    public String viewOrder(@PathVariable int orderId, Model model) {
        Order order = orderService.findById(orderId);
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(orderId);
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        return "order/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.delete(id);
        return "redirect:/orders";
    }
}
