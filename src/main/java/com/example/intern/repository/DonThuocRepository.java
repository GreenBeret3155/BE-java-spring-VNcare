package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern.model.DonThuoc;

public interface DonThuocRepository extends JpaRepository<DonThuoc, Long> {
	//query
	List<DonThuoc> findByDangkykhamId(Long dangkykhamid);
	void deleteByDangkykhamId(Long dangkykhamid);
}
