package com.exide.sfcrm.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.Destination;


@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer>  {
	
	@Query(value = "select * from tblDestinationPlace where destid=?1",nativeQuery=true)
	public List<Destination> getDestinationByDestId(Integer destid);

}
