package com.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.demo.pojo.Orders;
import com.demo.pojo.User;
import com.demo.service.OrderService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @PostMapping("/login")
    public String login(User user, HttpSession session){
        System.out.println(user.toString());
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> eq = wrapper.eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword());
        long count = userService.count(eq);
        if (count==0){
            return "error";
        }else {
            session.setAttribute("user",user);
//            return "redirect:/information";
            return "common";
        }

    }
    @GetMapping("/information")
    public String information(Model model){
        List<Orders> list = orderService.list();
        model.addAttribute("orders",list);
        return "information";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
