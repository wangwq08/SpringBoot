package com.example.wangwq.service;
import com.example.wangwq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserService extends JpaRepository<User, Integer> {
}
