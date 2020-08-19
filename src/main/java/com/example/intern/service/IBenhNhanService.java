package com.example.intern.service;

import java.util.List;

import com.example.intern.model.BenhNhan;

public interface IBenhNhanService {
	
	List<BenhNhan> getAll();
	BenhNhan getOneById(Long id);
	BenhNhan findByTaikhoanId(Long taikhoanid);
	BenhNhan save(BenhNhan benhnhan);
	void delete(Long id);
}
