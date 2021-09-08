package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Watchlists;

public interface WatchlistsRepository extends JpaRepository<Watchlists, Integer> {
	List<Watchlists> findByUserid(String email);
}
