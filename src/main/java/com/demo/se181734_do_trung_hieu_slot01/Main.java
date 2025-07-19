package com.demo.se181734_do_trung_hieu_slot01;

import com.demo.se181734_do_trung_hieu_slot01.pojo.*;
import com.demo.se181734_do_trung_hieu_slot01.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.demo.se181734_do_trung_hieu_slot01.repository")  // Chỉ định rõ thư mục chứa các repository
@EntityScan("com.demo.se181734_do_trung_hieu_slot01.pojo")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
//
//        // Lấy bean repository từ context
//        RoleRepository roleRepo = context.getBean(RoleRepository.class);
//        CategoryRepository categoryRepo = context.getBean(CategoryRepository.class);
//        AccountRepository accountRepo = context.getBean(AccountRepository.class);
//        OrchidRepository orchidRepo = context.getBean(OrchidRepository.class);
//        OrderRepository orderRepo = context.getBean(OrderRepository.class);
//        OrderDetailRepository orderDetailRepo = context.getBean(OrderDetailRepository.class);
//
//        // Thêm role
//        Role adminRole = new Role();
//        adminRole.setRoleName("ADMIN");
//        Role userRole = new Role();
//        userRole.setRoleName("USER");
//        roleRepo.save(adminRole);
//        roleRepo.save(userRole);
//
//        // Thêm category
//        Category cat = new Category();
//        cat.setCategoryName("Phi Điệp");
//        categoryRepo.save(cat);
//
//        // Thêm account
//        Account acc = new Account();
//        acc.setAccountName("Nguyen Van A");
//        acc.setEmail("vana@gmail.com");
//        acc.setPassword("123456");  // Mật khẩu của tài khoản mẫu (có thể mã hóa mật khẩu sau)
//        acc.setRole(adminRole);  // Gán vai trò ADMIN cho tài khoản
//        accountRepo.save(acc);
//
//        // Thêm orchid
//        Orchid orchid = new Orchid();
//        orchid.setOrchidName("Phi Điệp 5ct");
//        orchid.setOrchidDescription("Hoa tím trắng, đẹp");
//        orchid.setIsNatural(true);
//        orchid.setPrice(200000.0);
//        orchid.setCategory(cat);
//        orchidRepo.save(orchid);
//
//        // Thêm order
//        Order order = new Order();
//        order.setAccount(acc);  // Gán tài khoản vào đơn hàng
//        order.setOrderDate(new java.util.Date());
//        order.setOrderStatus("PAID");
//        order.setTotalAmount(200000.0);
//        orderRepo.save(order);
//
//        // Thêm order detail
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setOrder(order);
//        orderDetail.setOrchid(orchid);
//        orderDetail.setPrice(200000.0);
//        orderDetail.setQuantity(1);
//        orderDetailRepo.save(orderDetail);
//
//        System.out.println("Đã thêm dữ liệu mẫu!");
    }
}
