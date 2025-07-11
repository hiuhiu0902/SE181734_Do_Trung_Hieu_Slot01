package com.demo.se181734_do_trung_hieu_slot01.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "orchid_id")
    public Orchid orchid;

    public Double price;
    public Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order order;

    // getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Orchid getOrchid() { return orchid; }
    public void setOrchid(Orchid orchid) { this.orchid = orchid; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}
