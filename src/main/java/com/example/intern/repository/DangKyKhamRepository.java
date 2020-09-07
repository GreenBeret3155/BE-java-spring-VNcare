package com.example.intern.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.DangKyKham;

@Repository
public interface DangKyKhamRepository extends JpaRepository<DangKyKham, Long> {
	//query
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikham(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, boolean trangthaikham);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBacsiId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, boolean trangthaikham, Long bacsiid);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBenhnhanId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, boolean trangthaikham, Long benhnhanid);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBacsiIdAndBenhnhanId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, boolean trangthaikham, Long bacsiid, Long benhnhanid);
}
