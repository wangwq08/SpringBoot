package com.example.wangwq;

import com.example.wangwq.model.User;
import com.example.wangwq.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author wangwq
 * @date 2017.9.25 16:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testAdd() {
        User user = new User();
        user.setEmail("644813712@qq.com");
        user.setNickName("小王子");
        user.setPassword("123456");
        user.setUserName("king");

        userService.save(user);
    }

    @Test
    public void testFind() {
        User user = userService.findOne(10);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }

    @Test
    public void testUpdate() {
        User user = userService.findOne(3);
        user.setNickName("wangwq");
        userService.save(user);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }

    @Test
    public void testDelete() {
        userService.delete(2);
    }

    @Test
    public void testAddBatch() {
        for(Integer i=0; i < 5; i++) {
            User user = new User();
            user.setNickName("昵称"+i);
            user.setUserName("user"+i);
            user.setPassword("pwd"+i);
            user.setEmail("email"+i+"@domain.com");
            userService.save(user);
        }
    }

    @Test
    public void testFindAll() {
        List<User> list = userService.findAll();
        for(User u : list) {
            System.out.println("nickName : "+u.getNickName()+", email : "+u.getEmail());
        }
    }
}