package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Account;
import org.springframework.stereotype.Service;


import java.util.List;

public interface AccountService {

    List<Account> findAll();
    Account findById(int accountId);
    void save(Account account);
    void delete(int accountId);
    void update(Account account);
    Account findByEmail(String email); // Tìm tài khoản theo email
}
