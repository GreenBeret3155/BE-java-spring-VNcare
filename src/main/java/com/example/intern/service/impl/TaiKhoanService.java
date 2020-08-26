package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.TaiKhoan;
import com.example.intern.repository.TaiKhoanRepository;
import com.example.intern.service.ITaiKhoanService;

@Service
public class TaiKhoanService implements ITaiKhoanService {
	
	@Autowired
	private TaiKhoanRepository taikhoanRepository;
	
	@Override
	public List<TaiKhoan> getAll() throws ResourceNotFoundException{
		List<TaiKhoan> taikhoan = taikhoanRepository.findAll();
		if(taikhoan == null) throw new ResourceNotFoundException("TaiKhoan");
		return taikhoan;
	}
	
	@Override
	public TaiKhoan getOneById(Long id) throws ResourceNotFoundException{
		TaiKhoan taikhoan = taikhoanRepository.findOne(id);
		if(taikhoan == null) throw new ResourceNotFoundException("TaiKhoan", "id", id);
		return taikhoan;
	}
	
	@Override
	public TaiKhoan save(TaiKhoan taikhoan) {
		if(taikhoan.getId() == null) return taikhoanRepository.save(taikhoan);
		TaiKhoan taikhoan2 = taikhoanRepository.getOne(taikhoan.getId());
		if(taikhoan2 != null) throw new DuplicateIdException("TaiKhoan", taikhoan.getId());
		return taikhoanRepository.save(taikhoan);
	}
	
	@Override
	public void delete(Long id) {
		taikhoanRepository.delete(id);
	}

}
