package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.Thuoc;
import com.example.intern.repository.ThuocRepository;
import com.example.intern.service.IThuocService;

@Service
public class ThuocService implements IThuocService {
	
	@Autowired
	private ThuocRepository thuocRepository;
	
	@Override
	public List<Thuoc> getAll(){
		return thuocRepository.findAll();
	}
	
	@Override
	public Thuoc getOneById(Long id) {
		return thuocRepository.findOne(id);
	}
	
	@Override
	public Thuoc save(Thuoc thuoc) {
		return thuocRepository.save(thuoc);
	}
	
	@Override
	public void delete(Long id) {
		thuocRepository.delete(id);
	}
	
}
