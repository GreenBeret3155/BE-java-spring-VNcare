package com.example.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.Benh;

@Repository
public interface BenhRepository extends JpaRepository<Benh, Long> {
	//query
}
