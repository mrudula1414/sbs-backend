package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.WatchListModel;

public interface WatchListRepository extends JpaRepository<WatchListModel,Integer>{

}
