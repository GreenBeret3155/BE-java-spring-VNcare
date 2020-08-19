package com.example.intern.service;

import java.util.List;

import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;

public interface IQuanHeService {
	List<QuanHe> getAll();
	List<QuanHe> findByBenhnhanchinhId(Long benhnhanchinhid);
	QuanHe findByBenhnhanchinhIdAndBenhnhanphuId(Long benhnhanchinhid, Long benhnhanphuid);
	QuanHe save(QuanHe quanhe);
	void deleleByBenhnhanchinhIdAndBenhnhanphu(BenhNhan benhnhanchinh, BenhNhan benhnhanphu);
}
