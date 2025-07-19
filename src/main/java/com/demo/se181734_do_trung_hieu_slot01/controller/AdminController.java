package com.demo.se181734_do_trung_hieu_slot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard"; // tên file trong templates/admin/
    }
}
