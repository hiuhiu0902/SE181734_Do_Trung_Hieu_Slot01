package com.demo.se181734_do_trung_hieu_slot01.repository;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
