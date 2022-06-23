package com.demo;

import com.demo.pojo.Orders;
import com.demo.pojo.User;
import com.demo.service.OrderService;
import com.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Test
    public void test1(){
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }
    @Test
    public void test2(){
        List<Orders> list = orderService.list();
        list.forEach(System.out::println);
    }
}
