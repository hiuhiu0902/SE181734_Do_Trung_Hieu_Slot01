package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(int id);
    void save(Order order);
    void update(Order order);
    void delete(int id);
}
