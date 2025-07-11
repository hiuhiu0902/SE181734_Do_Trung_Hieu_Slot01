package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Orchid;
import com.demo.se181734_do_trung_hieu_slot01.repository.OrchidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrchidServiceImpl implements OrchidService {
    @Autowired
    OrchidRepository orchidRepository;

    @Override
    public List<Orchid> findAll() { return orchidRepository.findAll(); }
    @Override
    public Orchid findById(int id) { return orchidRepository.findById(id).orElse(null); }
    @Override
    public void save(Orchid orchid) { orchidRepository.save(orchid); }
    @Override
    public void update(Orchid orchid) { orchidRepository.save(orchid); }
    @Override
    public void delete(int id) { orchidRepository.deleteById(id); }
}