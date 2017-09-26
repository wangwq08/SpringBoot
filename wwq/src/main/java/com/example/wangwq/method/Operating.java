package com.example.wangwq.method;

import com.example.wangwq.model.User;
import com.example.wangwq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wangwq
 * @date 2017.9.26 9:14
 */
@SpringBootApplication
@ActiveProfiles("dev")
public class Operating {

    @Autowired
    private static IUserService userService;

    public static void add(){
        User user =new User();
        user.setEmail("644813712@qq.com");
        user.setNickName("小白杨");
        user.setPassword("root");
        user.setUserName("Jachin");

        userService.save(user);
    }

    public static void find(){
        User user=userService.findOne(15);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }

    public static void update(){
        User user = userService.findOne(4);
        user.setNickName("wangwq");
        userService.save(user);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }

    public static void delete(){
        userService.delete(18);
    }

    public static void addBatch(){
        for(int i=0; i<4;i++){
            User user =new User();
            user.setNickName("昵称"+i);
            user.setUserName("user"+i);
            user.setPassword("pwd"+i);
            user.setEmail("email"+i+"@qq.com");
            userService.save(user);
        }
    }

    public static void findAll(){
        List<User> list=userService.findAll();
        for(User u:list){
            System.out.println("nickName: "+u.getNickName()+", email: "+u.getEmail());
        }
    }

}
