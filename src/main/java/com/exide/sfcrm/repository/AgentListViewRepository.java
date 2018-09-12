package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AgentList;
import com.exide.sfcrm.model.AgentListView;

@Repository
public interface AgentListViewRepository extends
		JpaRepository<AgentListView, Integer> {

	@Query(value = "SELECT  *  FROM [TVFUserWiseAgents] (?1)", nativeQuery = true)
	public List<AgentListView> TVFUserWiseAgents(String UId);

}
