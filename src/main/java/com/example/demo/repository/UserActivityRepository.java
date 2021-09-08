package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MySharesModel;
import com.example.demo.models.UserActivity;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Integer>{


	//List<UserActivity> findUserActivitiesByUserid(String userid);
	List<UserActivity> findByUserid(String email);
}

