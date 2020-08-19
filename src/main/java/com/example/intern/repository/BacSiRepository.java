package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.BacSi;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Long> {
	//query
	List<BacSi> findByKhoaId(Long khoaid);
	BacSi findByTaikhoanId (Long taikhoanid);
}
