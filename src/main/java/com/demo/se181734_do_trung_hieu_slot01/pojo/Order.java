package com.demo.se181734_do_trung_hieu_slot01.pojo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    public Account account;

    @Temporal(TemporalType.TIMESTAMP)
    public Date orderDate;

    public String orderStatus;
    public Double totalAmount;

    @OneToMany(mappedBy = "order")
    public Set<OrderDetail> orderDetails;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Set<OrderDetail> getOrderDetails() { return orderDetails; }
    public void setOrderDetails(Set<OrderDetail> orderDetails) { this.orderDetails = orderDetails; }
}
