package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.ContestTripMap;


@Repository
public interface TblContestTripMapRepository extends JpaRepository<ContestTripMap, Integer> {

	
	@Query(value = "select * from [tblContestTripMap] where contestid=?1",nativeQuery=true)
	public List<ContestTripMap> getTripDetails(Integer contestId);
}
