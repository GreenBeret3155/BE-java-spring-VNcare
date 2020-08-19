package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.DonViTinh;
import com.example.intern.repository.DonViTinhRepository;
import com.example.intern.service.IDonViTinhService;

@Service
public class DonViTinhService implements IDonViTinhService {
	
	@Autowired
	private DonViTinhRepository donvitinhRepository;
	
	@Override
	public List<DonViTinh> getAll(){
		return donvitinhRepository.findAll();
	}
	
	@Override
	public DonViTinh getOneById(Long id) {
		return donvitinhRepository.findOne(id);
	}
	
	@Override
	public DonViTinh save(DonViTinh donvitinh) {
		return donvitinhRepository.save(donvitinh);
	}
	
	@Override
	public void delete (Long id) {
		donvitinhRepository.delete(id);
	}
}
