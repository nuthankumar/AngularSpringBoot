package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.MakerContestListView;

public interface MakerContestListRepository extends
		JpaRepository<MakerContestListView, Long> {

	@Query(value = " SELECT * FROM [TVFUserWiseTdyContestListsCashMaker] (?1) ORDER bY contestId OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY", nativeQuery = true)
	public List<MakerContestListView> findAll(String UId, int offset, int limit);

	@Query(value = "SELECT count(*) FROM [TVFUserWiseTdyContestListsCashMaker] (?1) ", nativeQuery = true)
	public Integer getMakerContestListCount(String Uid);

	@Query(value = "SELECT count(*) FROM [TVFUserWiseTdyContestListsTicketsMaker] (?1) ", nativeQuery = true)
	public Integer getMakerContestTicketsList(String userId);

	@Query(value = " SELECT * FROM [TVFUserWiseTdyContestListsTicketsMaker] (?1) ORDER bY contestId OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY", nativeQuery = true)
	public List<MakerContestListView> getMakerContestTicketsList(String userId,
			Integer offset, Integer limit);

}
