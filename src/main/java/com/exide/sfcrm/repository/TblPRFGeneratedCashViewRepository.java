package com.exide.sfcrm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.TblPRFGeneratedCashView;

@Transactional
@Repository
public interface TblPRFGeneratedCashViewRepository extends
		JpaRepository<TblPRFGeneratedCashView, Integer> {

	@Query(value = "SELECT * FROM [TVFPRFPrintPRFNO] (?1,?2)", nativeQuery = true)
	List<TblPRFGeneratedCashView> findByPrfNo(String prfNo, Integer cid);

	@Query(value = "SELECT cid from tblCUmap where uid=?1", nativeQuery = true)
	Integer findByCid(String uid);

	@Query(value = "SELECT * FROM [TVFPRFPrintPrfGENDate] (?1,?2)", nativeQuery = true)
	List<TblPRFGeneratedCashView> findByPrfGENDate(Integer prfGENDate, Integer id);

	@Query(value = "SELECT * FROM [TVFPRFPrintPrfByDate] (?1,?2,?3)", nativeQuery = true)
	List<TblPRFGeneratedCashView> findByDate(Integer startDate, Integer endDate, Integer cid);
}
