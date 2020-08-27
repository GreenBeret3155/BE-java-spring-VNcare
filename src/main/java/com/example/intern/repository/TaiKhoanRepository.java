package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
	//query
	List<TaiKhoan> findByEmailContaining(String email);
	List<TaiKhoan> findBySdtContaining(String sdt);
	List<TaiKhoan> findByEmailContainingAndSdtContaining(String email, String sdt);
}
