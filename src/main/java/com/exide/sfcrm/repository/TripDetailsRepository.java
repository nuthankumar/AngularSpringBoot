package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.TripDetailsView;


@Repository
public interface TripDetailsRepository extends JpaRepository<TripDetailsView, Integer>{
	
	
	@Query(value = " EXEC [GetTripDetailsForDropdown] ?1", nativeQuery = true)
	List<TripDetailsView> tripDetails(Integer contestId);

}
