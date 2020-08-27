package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.TaiKhoan;
import com.example.intern.repository.TaiKhoanRepository;
import com.example.intern.service.ITaiKhoanService;

@Service
public class TaiKhoanService implements ITaiKhoanService {
	
	@Autowired
	private TaiKhoanRepository taikhoanRepository;
	
	@Override
	public List<TaiKhoan> queryByEmailAndSdt(String email, String sdt) throws ResourceNotFoundException{
		if(email == null && sdt == null) return taikhoanRepository.findAll();
		if(email == null ) {
			List<TaiKhoan> taikhoan = taikhoanRepository.findBySdtContaining(sdt);
			if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan","sdt",sdt);
			return taikhoan;
		}
		if(sdt == null) {
			List<TaiKhoan> taikhoan = taikhoanRepository.findByEmailContaining(email);
			if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan", "email",email);
			return taikhoan;
		}
		List<TaiKhoan> taikhoan = taikhoanRepository.findByEmailContainingAndSdtContaining(email,sdt);
		if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan");
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
		return taikhoanRepository.save(taikhoan);
	}
	
	@Override
	public void delete(Long id) {
		taikhoanRepository.delete(id);
	}

}
