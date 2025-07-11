package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(int id);
    void save(Role role);
    void update(Role role);
    void delete(int id);
}
