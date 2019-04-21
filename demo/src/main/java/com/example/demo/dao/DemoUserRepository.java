package com.example.demo.dao;

import com.example.demo.pojo.DemoUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoUserRepository extends JpaRepository<DemoUserInfo,String> {



}
