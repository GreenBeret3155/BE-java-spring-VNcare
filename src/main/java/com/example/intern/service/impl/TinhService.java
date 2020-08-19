package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.Tinh;
import com.example.intern.repository.TinhRepository;
import com.example.intern.service.ITinhService;

@Service
public class TinhService implements ITinhService {
	
	@Autowired
	private TinhRepository tinhRepository;
	
	@Override
	public List<Tinh> getAll() {
		return (List<Tinh>) tinhRepository.findAll();
	}
	
	@Override
	public Tinh getOneById(Long id) {
		return (Tinh) tinhRepository.findOne(id);
	}
	
	@Override
	public Tinh save(Tinh tinh) {
		return tinhRepository.save(tinh);
	}
	
	@Override
	public void delete(Long id) {
		tinhRepository.delete(id);
	}
	
}





























