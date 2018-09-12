package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.exide.sfcrm.model.ApproverTwoTicketView;

@Repository
public interface ApproverTwoTicketRepository extends
		JpaRepository<ApproverTwoTicketView, Integer> {

	@Query(value = "SELECT * FROM [TVFTicketsApprove2List] (?1) ORDER by prfgendate OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY", nativeQuery = true)
	public List<ApproverTwoTicketView> getApproverTwoTicketContestList(
			String userId, Integer offset, Integer limit);

	@Query(value = "SELECT count(*) FROM [TVFTicketsApprove2List] (?1)", nativeQuery = true)
	public Integer getTicketApprove2(String userId);
}
