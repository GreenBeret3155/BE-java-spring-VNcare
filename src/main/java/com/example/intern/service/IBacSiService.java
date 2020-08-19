package com.example.intern.service;

import java.util.List;

import com.example.intern.model.BacSi;

public interface IBacSiService {
	
	List<BacSi> getAll();
	BacSi getOneById(Long id);
	List<BacSi> findByKhoaId(Long khoaid);
	BacSi findByTaikhoanId(Long taikhoanid);
	BacSi save(BacSi bacsi);
	void delete(Long id);
}
