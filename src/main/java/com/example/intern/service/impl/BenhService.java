package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.Benh;
import com.example.intern.repository.BenhRepository;
import com.example.intern.service.IBenhService;

@Service
public class BenhService implements IBenhService {
	
	@Autowired
	private BenhRepository benhRepository;
	
	@Override
	public List<Benh> getAll(){
		return benhRepository.findAll();
	}
	
	@Override
	public Benh getOneById(Long id) {
		return benhRepository.findOne(id);
	}
	
	@Override
	public Benh save(Benh benh) {
		return benhRepository.save(benh);
	}
	
	@Override
	public void delete(Long id) {
		benhRepository.delete(id);
	}
}
