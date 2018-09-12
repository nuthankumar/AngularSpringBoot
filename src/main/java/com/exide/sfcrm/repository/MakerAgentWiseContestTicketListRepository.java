package com.exide.sfcrm.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.AgentWiseContestTicketView;


public interface MakerAgentWiseContestTicketListRepository extends JpaRepository<AgentWiseContestTicketView, Long>{

	@Query(value = " SELECT * FROM [TVFTdyContestWiseagentsListsTicketsMaker] (?1,?2)" , nativeQuery = true)
	public Set<AgentWiseContestTicketView> getakerAgentWiseContestTicketsList(
			String userName, Long contestId);

	
	
	
}
