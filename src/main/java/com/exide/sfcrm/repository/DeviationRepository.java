package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.DeviationCashView;

@Repository
public interface DeviationRepository extends
		CrudRepository<DeviationCashView, Long> {

	@Query(value = "SELECT * FROM [TVFContestWiseTdyDeviationListsCashDApprover] (?1) ORDER by contestid OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY", nativeQuery = true)
	public List<DeviationCashView> getDeviationListCash(String userId,
			int offset, int limit);


	@Query(value = "SELECT count(*) FROM [TVFContestWiseTdyDeviationListsCashDApprover] (?1)", nativeQuery = true)
	public Integer getDeviationCashCount(String userId);


	
}
