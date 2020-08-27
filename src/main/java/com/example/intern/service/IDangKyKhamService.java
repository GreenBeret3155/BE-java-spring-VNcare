package com.example.intern.service;

import java.util.List;

import com.example.intern.model.DangKyKham;

public interface IDangKyKhamService {
	List<DangKyKham> queryQuery(Long benhnhanId, Long bacsiId, Long benhchinhId);
	DangKyKham getOneById(Long id);
	DangKyKham save(DangKyKham dangkykham);
	void delete(Long id);
}

