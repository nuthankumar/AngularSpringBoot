package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.TicketExcelView;

/**
 * 
 * @author vasavivr
 *
 */
public interface TicketExcelRepository extends JpaRepository<TicketExcelView, Integer>{
	
	@Query(value = " EXEC [GetTicketOption] ?1", nativeQuery = true)
	List<TicketExcelView> executeTicketData(String userId);

}
