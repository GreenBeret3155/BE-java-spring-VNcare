package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.TaiKhoan;
import com.example.intern.repository.TaiKhoanRepository;
import com.example.intern.service.ITaiKhoanService;

@Service
public class TaiKhoanService implements ITaiKhoanService {
	
	@Autowired
	private TaiKhoanRepository taikhoanRepository;
	
	@Override
	public List<TaiKhoan> getAll(){
		return taikhoanRepository.findAll();
	}
	
	@Override
	public TaiKhoan getOneById(Long id) {
		return taikhoanRepository.findOne(id);
	}
	
	@Override
	public TaiKhoan save(TaiKhoan taikhoan) {
		return taikhoanRepository.save(taikhoan);
	}
	
	@Override
	public void delete(Long id) {
		taikhoanRepository.delete(id);
	}

}
