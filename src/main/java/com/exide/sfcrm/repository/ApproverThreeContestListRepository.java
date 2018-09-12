package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.ApproverThreeContestView;

public interface ApproverThreeContestListRepository extends
		JpaRepository<ApproverThreeContestView, Integer> {
	
	@Query(value = "SELECT PRFNoGenREF, PRFNo, PRFGENDate, PRFAmount, Status FROM (select * from TVFCashApprove3List (?1) ORDER by prfgendate OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY) QryTVFCashApprove3List GROUP BY PRFNoGenREF, PRFNo, PRFGENDate, PRFAmount, Status ", nativeQuery = true)
	public List<ApproverThreeContestView> getApproverThreeContestList(
			String userId, int offSet, int limit);

	@Query(value = "SELECT  count (*) from [TVFCashApprove3List] (?1)", nativeQuery = true)
	public Integer getApproverThreeContestListCount(String userId);

}
