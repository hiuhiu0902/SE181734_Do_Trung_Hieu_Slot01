package com.demo.se181734_do_trung_hieu_slot01.service;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Account;
import com.demo.se181734_do_trung_hieu_slot01.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account); // save() sẽ update nếu id đã tồn tại
    }

    @Override
    public void delete(int id) {
        accountRepository.deleteById(id);
    }

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);  // Tìm tài khoản theo email
    }
}