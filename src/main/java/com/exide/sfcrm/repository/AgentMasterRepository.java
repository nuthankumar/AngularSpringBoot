package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AgentMaster;
/**
 * 
 * @author vasavivr
 *
 */

@Repository
public interface AgentMasterRepository extends JpaRepository<AgentMaster,Long> {
	@Override
	public List<AgentMaster> findAll();
	

}
