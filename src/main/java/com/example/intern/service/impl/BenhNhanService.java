package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.BenhNhan;
import com.example.intern.repository.BenhNhanRepository;
import com.example.intern.service.IBenhNhanService;

@Service
public class BenhNhanService implements IBenhNhanService {
	
	@Autowired
	private BenhNhanRepository benhnhanRepository;
	
	@Override
	public List<BenhNhan> getAll(){
		return benhnhanRepository.findAll();
	}
	
	@Override
	public BenhNhan getOneById(Long id) {
		return benhnhanRepository.getOne(id);
	}
	
	@Override
	public BenhNhan findByTaikhoanId(Long taikhoanid) {
		return benhnhanRepository.findByTaikhoanId(taikhoanid);
	}
	
	@Override
	public BenhNhan save(BenhNhan benhnhan) {
		return benhnhanRepository.save(benhnhan);
	}
	
	@Override
	public void delete(Long id) {
		benhnhanRepository.delete(id);
	}
	
	
}
