package com.demo.se181734_do_trung_hieu_slot01.pojo;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    public int accountId;

    @Column(name = "acount_name")
    public String accountName;

    @Column(name = "email", unique = true)
    public String email;

    @Column(name = "password")
    public String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;

    public Account(Role role, String password, String email, String accountName) {
        this.role = role;
        this.password = password;
        this.email = email;
        this.accountName = accountName;
    }

    public Account(int accountId, String accountName, String email, String password, Role role) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
