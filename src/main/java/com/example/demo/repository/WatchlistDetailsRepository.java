package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.WatchlistDetails;

public interface WatchlistDetailsRepository extends JpaRepository<WatchlistDetails, Integer> {

}
