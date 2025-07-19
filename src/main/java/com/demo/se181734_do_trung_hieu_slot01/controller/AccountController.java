package com.demo.se181734_do_trung_hieu_slot01.controller;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Account;
import com.demo.se181734_do_trung_hieu_slot01.service.AccountService;
import com.demo.se181734_do_trung_hieu_slot01.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/users")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", accountService.findAll());
        return "admin/users";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("pageTitle", "Thêm Mới Người Dùng");
        return "admin/add_edit_user";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Account account = accountService.findById(id);
            if (account == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy người dùng với ID: " + id);
                return "redirect:/admin/users";
            }
            model.addAttribute("account", account);
            model.addAttribute("roles", roleService.findAll());
            model.addAttribute("pageTitle", "Chỉnh Sửa Người Dùng");
            return "admin/add_edit_user";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi: " + e.getMessage());
            return "redirect:/admin/users";
        }
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("account") Account account, RedirectAttributes redirectAttributes) {
        // Nếu không nhập mật khẩu mới (trường hợp edit), giữ lại mật khẩu cũ
        if (account.getAccountId() != 0 && (account.getPassword() == null || account.getPassword().isEmpty())) {
            Account existingAccount = accountService.findById(account.getAccountId());
            if (existingAccount != null) {
                account.setPassword(existingAccount.getPassword());
            }
        }

        accountService.save(account);
        redirectAttributes.addFlashAttribute("successMessage", "Đã lưu thông tin người dùng thành công!");
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            accountService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Đã xóa người dùng thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể xóa người dùng này.");
        }
        return "redirect:/admin/users";
    }
}
