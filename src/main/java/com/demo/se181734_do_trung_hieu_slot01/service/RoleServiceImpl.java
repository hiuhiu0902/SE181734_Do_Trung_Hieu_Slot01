package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Role;
import com.demo.se181734_do_trung_hieu_slot01.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() { return roleRepository.findAll(); }
    @Override
    public Role findById(int id) { return roleRepository.findById(id).orElse(null); }
    @Override
    public void save(Role role) { roleRepository.save(role); }
    @Override
    public void update(Role role) { roleRepository.save(role); }
    @Override
    public void delete(int id) { roleRepository.deleteById(id); }
    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}