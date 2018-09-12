package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.TblPRFGeneratedTicketView;

public interface TblPRFGeneratedTicketViewRepository extends
		JpaRepository<TblPRFGeneratedTicketView, Integer> {

	@Query(value = "SELECT * FROM [TVFPRFPrintTicketPrfGENDate] (?1,?2)", nativeQuery = true)
	List<TblPRFGeneratedTicketView> findByPrfGENDate(Integer prfGENDate,
			Integer id);

	@Query(value = "SELECT * FROM [TVFPRFPrintTicketPRFNO] (?1,?2)", nativeQuery = true)
	List<TblPRFGeneratedTicketView> findByPrfNo(String prfNo, Integer id);

	@Query(value = "SELECT * FROM [TVFPRFPrintTicketPrfByDate] (?1,?2,?3)", nativeQuery = true)
	List<TblPRFGeneratedTicketView> findByDate(Integer startDate,
			Integer endDate, Integer cid);
}
