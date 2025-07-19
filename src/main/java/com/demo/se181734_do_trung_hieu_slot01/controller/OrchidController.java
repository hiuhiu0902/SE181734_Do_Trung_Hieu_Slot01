package com.demo.se181734_do_trung_hieu_slot01.controller;

import com.demo.se181734_do_trung_hieu_slot01.pojo.Orchid;
import com.demo.se181734_do_trung_hieu_slot01.service.CategoryService;
import com.demo.se181734_do_trung_hieu_slot01.service.OrchidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin/orchids")
public class OrchidController {
    @Autowired
    private OrchidService orchidService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("orchids", orchidService.findAll());
        return "admin/orchids";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("orchid", new Orchid());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/add_orchid";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("orchid", orchidService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "admin/edit_orchid";
    }

    @PostMapping("/save")
    public String saveOrchid(@ModelAttribute Orchid orchid, @RequestParam("image") MultipartFile image) throws IOException {
        if (!image.isEmpty()) {
            if (image.getSize() > 2 * 1024 * 1024) {  // Giới hạn 2MB
                throw new IOException("File quá lớn. Vui lòng chọn file có kích thước nhỏ hơn 2MB.");
            }
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());

            String uploadDir = "C:/Uploads/";

            File targetDir = new File(uploadDir);
            if (!targetDir.exists()) {
                targetDir.mkdirs(); // Tạo thư mục nếu chưa có
            }

            File targetFile = new File(uploadDir + fileName);

            image.transferTo(targetFile);

            orchid.setOrchidUrl(fileName);
        }
        orchidService.save(orchid);
        return "redirect:/admin/orchids";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        orchidService.delete(id);
        return "redirect:/admin/orchids";
    }
}

