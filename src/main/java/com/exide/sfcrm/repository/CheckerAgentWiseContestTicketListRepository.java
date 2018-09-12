package com.exide.sfcrm.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.AgentWiseContestTicketView;
/**
 * 
 * @author vasavivr
 *
 */
public interface CheckerAgentWiseContestTicketListRepository extends JpaRepository<AgentWiseContestTicketView, Long> {

	
	@Query(value = " SELECT * FROM [TVFTdyContestWiseagentsListsTicketsCheker] (?1,?2)" , nativeQuery = true)
	public Set<AgentWiseContestTicketView> getcheckerAgentWiseContestTicketsList(
			String userName, Long contestId);
}
