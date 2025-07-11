package com.demo.se181734_do_trung_hieu_slot01.service;


import com.demo.se181734_do_trung_hieu_slot01.pojo.Category;
import com.demo.se181734_do_trung_hieu_slot01.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() { return categoryRepository.findAll(); }
    @Override
    public Category findById(int id) { return categoryRepository.findById(id).orElse(null); }
    @Override
    public void save(Category category) { categoryRepository.save(category); }
    @Override
    public void update(Category category) { categoryRepository.save(category); }
    @Override
    public void deleteById(int id) { categoryRepository.deleteById(id); }
}