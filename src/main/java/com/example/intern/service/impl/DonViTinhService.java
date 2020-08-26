package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.DonViTinh;
import com.example.intern.repository.DonViTinhRepository;
import com.example.intern.service.IDonViTinhService;

@Service
public class DonViTinhService implements IDonViTinhService {
	
	@Autowired
	private DonViTinhRepository donvitinhRepository;
	
	@Override
	public List<DonViTinh> getAll() throws ResourceNotFoundException{
		List<DonViTinh> donvitinh = donvitinhRepository.findAll();
		if(donvitinh == null) throw new ResourceNotFoundException("DonViTinh");
		return donvitinh;
	}
	
	@Override
	public DonViTinh getOneById(Long id) throws ResourceNotFoundException{
		DonViTinh donvitinh = donvitinhRepository.findOne(id);
		if(donvitinh == null) throw new ResourceNotFoundException("DonViTinh","id", id);
		return donvitinh;
	}
	
	@Override
	public DonViTinh save(DonViTinh donvitinh) {
		if(donvitinh.getId() == null) return donvitinhRepository.save(donvitinh);
		DonViTinh donvitinh2 = donvitinhRepository.getOne(donvitinh.getId());
		if(donvitinh2 != null) throw new DuplicateIdException("BenhNhan", donvitinh.getId());
		return donvitinhRepository.save(donvitinh);
	}
	
	@Override
	public void delete (Long id) {
		donvitinhRepository.delete(id);
	}
}
