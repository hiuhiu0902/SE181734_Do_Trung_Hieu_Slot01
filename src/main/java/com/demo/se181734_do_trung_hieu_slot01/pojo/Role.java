package com.demo.se181734_do_trung_hieu_slot01.pojo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer roleId;

    public String roleName;

    @OneToMany(mappedBy = "role")
    public Set<Account> accounts;

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public Set<Account> getAccounts() { return accounts; }
    public void setAccounts(Set<Account> accounts) { this.accounts = accounts; }
}
