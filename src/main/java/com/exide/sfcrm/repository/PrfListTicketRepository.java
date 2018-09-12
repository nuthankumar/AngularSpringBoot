/**
 * 
 */
package com.exide.sfcrm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.PrfListTicketView;

/**
 * @author saurabhp
 *
 */
@Repository
public interface PrfListTicketRepository extends JpaRepository<PrfListTicketView, Long>{
	
	@Query(value = " EXEC [generatePrfListforTickets] ?1,?2,?3,?4 ", nativeQuery = true)
	@Modifying
	@Transactional
	public void generatePrfForTickets(String comment, String agentType, String userId , String agentNo);

	@Query(value = " EXEC [GetPRFListTicket] ?1,?2 ", nativeQuery = true)
	public List<PrfListTicketView> getPRFListTicket(String userId, int agentTypeId); 

}
