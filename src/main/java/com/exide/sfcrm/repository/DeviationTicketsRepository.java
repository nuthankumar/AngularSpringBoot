package com.exide.sfcrm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.DeviationTicketsView;

@Repository
public interface DeviationTicketsRepository extends
		JpaRepository<DeviationTicketsView, Long> {

	@Query(value = "SELECT * FROM [TVFContestWiseTdyDeviationListsTicketsDApprover] (?1) ORDER by contestid OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY", nativeQuery = true)
	List<DeviationTicketsView> getDeviationTicketsList(String userId,
			Integer offset, Integer limit);

	@Query(value = "SELECT count(*) FROM [TVFContestWiseTdyDeviationListsTicketsDApprover] (?1)", nativeQuery = true)
	Integer getDeviationTicketsCount(String userId);
	
	@Query(value = "Delete from tmptblticketsdeviation", nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteTmptblTicketsDeviation();
}
