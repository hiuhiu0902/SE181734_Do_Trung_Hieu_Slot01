package com.demo.se181734_do_trung_hieu_slot01.controller;

import com.demo.se181734_do_trung_hieu_slot01.service.OrchidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private OrchidService orchidService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("orchids", orchidService.findAll());  // Hiển thị tất cả hoa lan
        return "home";
    }
}
