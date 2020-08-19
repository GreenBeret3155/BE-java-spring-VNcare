package com.example.intern.service;

import java.util.List;
import com.example.intern.model.TaiKhoan;


public interface ITaiKhoanService {
	
	List<TaiKhoan> getAll();
	TaiKhoan getOneById(Long id);
	TaiKhoan save(TaiKhoan taikhoan);
	void delete(Long id);
}
