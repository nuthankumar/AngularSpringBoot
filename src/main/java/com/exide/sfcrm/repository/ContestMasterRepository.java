package com.exide.sfcrm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.ContestMaster;

/**
 * 
 * @author vasavivr
 *
 */
@Repository
public interface ContestMasterRepository extends
		JpaRepository<ContestMaster, Long> {

	@Query(value = "select count(*) from tblcontestmaster", nativeQuery = true)
	public Integer getCount();

	@Query(value = "SELECT * FROM  tblcontestmaster  ORDER bY contestid OFFSET (?1)  ROWS FETCH NEXT (?2) ROWS ONLY", nativeQuery = true)
	public List<ContestMaster> findAll(Integer offset, Integer limit);

	@Query(value = "EXEC [AddContest] ?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13", nativeQuery = true)
	@Modifying
	@Transactional
	public void executeAddContest(String userId, Boolean chkTrip,
			Boolean chkCash, Integer destId, Float cashAmt, Float tripAmt,
			String contestName, Integer startDate, Integer cid,
			Integer endDate, String contestType, String agtypes,
			String attachment);
}
