package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.ContestView;

@Repository
public interface ContestViewRepository extends JpaRepository<ContestView, Integer>{

	
	@Query(value = " EXEC [GetAllContests] ", nativeQuery = true)
	List<ContestView> executeGetAllContests();

	



}
