package com.example.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.BenhNhan;

@Repository
public interface BenhNhanRepository extends JpaRepository<BenhNhan, Long> {
	//query
	BenhNhan findByTaikhoanId(Long taikhoanid);
}
