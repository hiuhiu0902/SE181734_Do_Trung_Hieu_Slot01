package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Orchid;

import java.util.List;

public interface OrchidService {
    List<Orchid> findAll();
    Orchid findById(int id);
    void save(Orchid orchid);
    void update(Orchid orchid);
    void delete(int id);
}
