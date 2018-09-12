package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.CostCenter;
/**
 * 
 * @author neethub
 *
 */
@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Integer>{
	
	@Query(value = "select * from cost_center",nativeQuery = true)
	public List<CostCenter> getCostCenterDetails();

}
