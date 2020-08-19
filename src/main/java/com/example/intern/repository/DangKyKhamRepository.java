package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.DangKyKham;

@Repository
public interface DangKyKhamRepository extends JpaRepository<DangKyKham, Long> {
	//query
	List<DangKyKham> findByBenhnhanId(Long benhnhanid);
	List<DangKyKham> findByBacsiId(Long bacsiid);
	List<DangKyKham> findByBenhId(Long benhchinhid);
}
