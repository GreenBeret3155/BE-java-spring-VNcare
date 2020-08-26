package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.BenhNhan;
import com.example.intern.repository.BenhNhanRepository;
import com.example.intern.service.IBenhNhanService;
import com.example.intern.exception.*;

@Service
public class BenhNhanService implements IBenhNhanService {
	
	@Autowired
	private BenhNhanRepository benhnhanRepository;
	
	@Override
	public List<BenhNhan> getAll() throws ResourceNotFoundException{
		List<BenhNhan> benhnhan = benhnhanRepository.findAll();
		if(benhnhan == null ) throw new ResourceNotFoundException("BenhNhan");
		return benhnhan;
	}
	
	@Override
	public BenhNhan getOneById(Long id) throws ResourceNotFoundException{
		BenhNhan benhnhan = benhnhanRepository.getOne(id);
		if(benhnhan == null ) throw new ResourceNotFoundException("BenhNhan","id",id);
		return benhnhan;
	}
	
	@Override
	public BenhNhan findByTaikhoanId(Long taikhoanid) throws ResourceNotFoundException{
		BenhNhan benhnhan = benhnhanRepository.findByTaikhoanId(taikhoanid);
		if(benhnhan == null ) throw new ResourceNotFoundException("BenhNhan","taikhoanid",taikhoanid);
		return benhnhan;
	}
	
	@Override
	public BenhNhan save(BenhNhan benhnhan) throws DuplicateIdException{
		if(benhnhan.getId() == null) return benhnhanRepository.save(benhnhan);
		BenhNhan benhnhan2 = benhnhanRepository.getOne(benhnhan.getId());
		if(benhnhan2 != null) throw new DuplicateIdException("BenhNhan", benhnhan.getId());
		return benhnhanRepository.save(benhnhan);
	}
	
	@Override
	public void delete(Long id) {
		benhnhanRepository.delete(id);
	}
	
	
}
