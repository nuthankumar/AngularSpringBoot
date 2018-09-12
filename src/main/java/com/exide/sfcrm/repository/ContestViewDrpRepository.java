package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.exide.sfcrm.model.ContestsDrpView;


@Repository
public interface ContestViewDrpRepository extends JpaRepository<ContestsDrpView, Integer> {
	
	@Query(value = " EXEC [GetContestForDropdown] ", nativeQuery = true)
	List<ContestsDrpView> executeGetContestsrp();


}
