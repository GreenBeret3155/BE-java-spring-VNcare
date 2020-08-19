package com.example.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.Thuoc;

@Repository
public interface ThuocRepository extends JpaRepository<Thuoc, Long> {
	//query
}
