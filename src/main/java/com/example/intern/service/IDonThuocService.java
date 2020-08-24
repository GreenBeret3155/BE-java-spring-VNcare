package com.example.intern.service;

import java.util.List;

import com.example.intern.model.DonThuoc;

public interface IDonThuocService {
	
	List<DonThuoc> getAll();
	DonThuoc getOneById(Long id);
	List<DonThuoc> findByDangKyKhamId(Long dangkykhamid);
	DonThuoc save(DonThuoc donthuoc);
	void delete(Long id);
	void deleteByDangkykhamId(Long dangkykhamid);
}
