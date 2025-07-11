package com.demo.se181734_do_trung_hieu_slot01.pojo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "orchids")
public class Orchid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer orchidId;

    @Column(name = "is_natural")
    public Boolean isNatural;

    @Column(length = 1024,name = "orchid_description")
    public String orchidDescription;

    @Column(name = "orchid_name")
    public String orchidName;
    @Column(name = "orchid_url")
    public String orchidUrl;
    public Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    @OneToMany(mappedBy = "orchid")
    public Set<OrderDetail> orderDetails;

    public Integer getOrchidId() { return orchidId; }
    public void setOrchidId(Integer orchidId) { this.orchidId = orchidId; }

    public Boolean getIsNatural() { return isNatural; }
    public void setIsNatural(Boolean isNatural) { this.isNatural = isNatural; }

    public String getOrchidDescription() { return orchidDescription; }
    public void setOrchidDescription(String orchidDescription) { this.orchidDescription = orchidDescription; }

    public String getOrchidName() { return orchidName; }
    public void setOrchidName(String orchidName) { this.orchidName = orchidName; }

    public String getOrchidUrl() { return orchidUrl; }
    public void setOrchidUrl(String orchidUrl) { this.orchidUrl = orchidUrl; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Set<OrderDetail> getOrderDetails() { return orderDetails; }
    public void setOrderDetails(Set<OrderDetail> orderDetails) { this.orderDetails = orderDetails; }
}
