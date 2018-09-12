package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AgentGregListView;


@Repository
public interface AgentGregListViewRepository extends JpaRepository<AgentGregListView, Integer> {

	@Query(value = "select * from [TVFAgentGregList] ()", nativeQuery = true)
	List<AgentGregListView> findByAgentName();
}
