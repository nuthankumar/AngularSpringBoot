package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.ApproverTwoContestView;

@Repository
public interface ApproverTwoContestListRepository extends JpaRepository<ApproverTwoContestView, Long> {

	@Query(value="SELECT PRFNoGenREF, PRFNo, PRFGENDate, PRFAmount, Status FROM (select * from TVFCashApprove2List (?1) ORDER by prfgendate OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY) QryTVFCashApprove2List GROUP BY PRFNoGenREF, PRFNo, PRFGENDate, PRFAmount, Status " , nativeQuery = true)
	List<ApproverTwoContestView> getApproverTwoContestList(String userId,
			int offset,int limit);
	
	@Query(value="SELECT count(*) FROM [TVFCashApprove2List] (?1)",nativeQuery = true)
	public Integer getCashApprove2List(String userId);

}
