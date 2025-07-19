package com.demo.se181734_do_trung_hieu_slot01.controller;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Account;
import com.demo.se181734_do_trung_hieu_slot01.pojo.Role;
import com.demo.se181734_do_trung_hieu_slot01.service.AccountService;
import com.demo.se181734_do_trung_hieu_slot01.service.RoleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    // Đã xóa PasswordEncoder

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Account account, HttpSession session, Model model) {
        Account foundAccount = accountService.findByEmail(account.getEmail());

        // Quay lại so sánh mật khẩu dạng văn bản thuần
        if (foundAccount != null && foundAccount.getPassword().equals(account.getPassword())) {
            session.setAttribute("user", foundAccount);

            if ("ADMIN".equals(foundAccount.getRole().getRoleName())) {
                return "redirect:/admin/users";
            } else {
                return "redirect:/";
            }
        }

        model.addAttribute("error", "Email hoặc mật khẩu không đúng.");
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("account") Account account, RedirectAttributes redirectAttributes) {
        if (accountService.findByEmail(account.getEmail()) != null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Email đã được sử dụng. Vui lòng chọn email khác.");
            return "redirect:/register";
        }

        Role userRole = roleService.findByName("USER");
        if (userRole == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi hệ thống: Không tìm thấy vai trò người dùng.");
            return "redirect:/register";
        }
        account.setRole(userRole);

        // Đã xóa dòng mã hóa mật khẩu

        accountService.save(account);

        redirectAttributes.addFlashAttribute("successMessage", "Đăng ký thành công! Vui lòng đăng nhập.");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
