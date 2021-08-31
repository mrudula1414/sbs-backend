package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.UserActivity;

public interface UserActivityRepository extends JpaRepository<UserActivity, Integer>{

}

