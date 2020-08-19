package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;
import com.example.intern.repository.QuanHeRepository;
import com.example.intern.service.IQuanHeService;

@Service
@Transactional
public class QuanHeService implements IQuanHeService {
	
	@Autowired
	private QuanHeRepository quanheRepository;
	
	@Override
	public List<QuanHe> getAll(){
		return quanheRepository.findAll();
	}
		
	@Override 
	public 	List<QuanHe> findByBenhnhanchinhId(Long benhnhanchinhid) {
		return quanheRepository.findByBenhnhanchinhId(benhnhanchinhid);
	}
	
	@Override
	public QuanHe findByBenhnhanchinhIdAndBenhnhanphuId(Long benhnhanchinhid, Long benhnhanphuid) {
		return quanheRepository.findByBenhnhanchinhIdAndBenhnhanphuId(benhnhanchinhid, benhnhanphuid);
	}
	
	@Override
	public QuanHe save(QuanHe quanhe) {
		return quanheRepository.save(quanhe);
	}
	
	@Override
	public void deleleByBenhnhanchinhIdAndBenhnhanphu(BenhNhan benhnhanchinh, BenhNhan benhnhanphu) {
		quanheRepository.deleleByBenhnhanchinhIdAndBenhnhanphu(benhnhanchinh, benhnhanphu);
	}
	
	
}




