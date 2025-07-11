package com.demo.se181734_do_trung_hieu_slot01.repository;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Orchid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrchidRepository extends JpaRepository<Orchid, Integer> {
}
