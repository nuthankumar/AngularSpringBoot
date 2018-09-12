/**
 * 
 */
package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.PRFListCashAdvanceView;

/**
 * @author neethub
 *
 */
public interface PRFListCashAdvanceRepository extends JpaRepository<PRFListCashAdvanceView, Long>{

	@Query (value = "select * from [TVFPRFAdvancePayList] (?1)",nativeQuery = true)
	public List<PRFListCashAdvanceView> getPRFListCashAdvance(String userId);
}
