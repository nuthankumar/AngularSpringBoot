package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.MakerContestListView;
/**
 * 
 * @author vasavivr
 *
 */
@Repository
public interface CheckerContestListRepository extends JpaRepository<MakerContestListView, Long>{

	@Query(value = " SELECT * FROM [TVFUserWiseTdyContestListsCashCheker] (?1) ORDER bY contestId OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY" , nativeQuery = true) 
	public List<MakerContestListView> TVFUserWiseTdyContestListsCashCheker(String userId,int offset,int limit);
	
	
	@Query(value = "SELECT count(*) FROM [TVFUserWiseTdyContestListsCashCheker] (?1) ",nativeQuery = true)
	public Integer getCheckerListCount(String userId);
	
	@Query(value = "SELECT count(*) FROM [TVFUserWiseTdyContestListsTicketsCheker] (?1) ", nativeQuery = true)
	public Integer getMakerContestTicketsList(String userId);

	@Query(value = " SELECT * FROM [TVFUserWiseTdyContestListsTicketsCheker] (?1) ORDER bY contestId OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY", nativeQuery = true)
	public List<MakerContestListView> getMakerContestTicketsList(String userId,
			Integer offset, Integer limit);


	
	
}
