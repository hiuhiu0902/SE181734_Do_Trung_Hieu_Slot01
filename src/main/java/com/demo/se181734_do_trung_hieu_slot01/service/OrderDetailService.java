package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Order;
import com.demo.se181734_do_trung_hieu_slot01.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAll();
    OrderDetail findById(int id);
    void save(OrderDetail orderDetail);
    void update(OrderDetail orderDetail);
    void delete(int id);
    List<OrderDetail> findByOrderId(int orderId);
}
