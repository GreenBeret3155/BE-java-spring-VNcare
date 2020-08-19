package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.BacSi;
import com.example.intern.repository.BacSiRepository;
import com.example.intern.service.IBacSiService;

@Service
public class BacSiService implements IBacSiService {

	@Autowired
	private BacSiRepository bacsiRepository;
	
	@Override
	public List<BacSi> getAll(){
		return bacsiRepository.findAll();
	}
	
	@Override
	public BacSi getOneById(Long id) {
		return bacsiRepository.findOne(id);
	}
	
	@Override
	public List<BacSi> findByKhoaId(Long khoaid){
		return bacsiRepository.findByKhoaId(khoaid);
	}
	
	@Override
	public BacSi findByTaikhoanId(Long taikhoanid) {
		return bacsiRepository.findByTaikhoanId(taikhoanid);
	}
	
	@Override
	public BacSi save(BacSi bacsi) {
		return bacsiRepository.save(bacsi);
	}
	
	@Override
	public void delete(Long id) {
		bacsiRepository.delete(id);
	}
}
