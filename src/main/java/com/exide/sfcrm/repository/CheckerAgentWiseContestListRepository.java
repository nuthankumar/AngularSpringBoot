package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AgentWiseContestView;

/**
 * 
 * @author vasavivr
 *
 */
@Repository
public interface CheckerAgentWiseContestListRepository extends
		JpaRepository<AgentWiseContestView, Long> {

	@Query(value = " SELECT * FROM [TVFTdyContestWiseagentsListsCashCheker]  (?1,?2)", nativeQuery = true)
	public List<AgentWiseContestView> TVFTdyContestWiseagentsListsCashCheker(
			String UId, String ContestID);

}
