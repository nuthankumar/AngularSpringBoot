package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.exide.sfcrm.model.ApproverOneTicketView;

@Repository
public interface ApproverOneTicketRepository extends JpaRepository<ApproverOneTicketView, Integer> {

	@Query(value="SELECT * FROM [TVFTicketsApprove1List] (?1) ORDER by prfgendate OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY" , nativeQuery = true)
	public List<ApproverOneTicketView> getApproverOneTicketContestList(
			String userId, Integer offset, Integer limit);

	@Query(value="SELECT count(*) FROM [TVFTicketsApprove1List] (?1)",nativeQuery=true)
	public Integer getTicketApprove1(String userId);
	
}
