package com.exide.sfcrm.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AgentWiseContestView;

@Repository
public interface MakerAgentWiseContestListRepository extends JpaRepository<AgentWiseContestView, Long>{
	
	@Query(value = " SELECT * FROM [TVFTdyContestWiseagentsListsCashMaker] (?1,?2)" , nativeQuery = true)
	public Set<AgentWiseContestView> find(String UId, Long ContestID);
	
	

}
