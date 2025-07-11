package com.demo.se181734_do_trung_hieu_slot01.pojo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer categoryId;

    public String categoryName;

    @OneToMany(mappedBy = "category")
    public Set<Orchid> orchids;

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public Set<Orchid> getOrchids() { return orchids; }
    public void setOrchids(Set<Orchid> orchids) { this.orchids = orchids; }
}
