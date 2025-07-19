package com.demo.se181734_do_trung_hieu_slot01.repository;

import com.demo.se181734_do_trung_hieu_slot01.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrderId(int orderId);  // Truy vấn chi tiết đơn hàng theo order_id
}
