package com.example.intern.service;

import java.util.List;

import com.example.intern.model.DangKyKham;

public interface IDangKyKhamService {
	List<DangKyKham> getAll();
	DangKyKham getOneById(Long id);
	List<DangKyKham> findByBenhnhanId(Long benhnhanid);
	List<DangKyKham> findByBacsiId(Long bacsiid);
	List<DangKyKham> findByBenhId(Long benhchinhid);
	DangKyKham save(DangKyKham dangkykham);
	void delete(Long id);
}

