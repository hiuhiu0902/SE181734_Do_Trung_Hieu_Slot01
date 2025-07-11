package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    void save(Category category);
    void update(Category category);
    void deleteById(int id);
}
