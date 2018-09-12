package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AgentList;
/**
 * 
 * @author vasavivr
 *
 */
@Repository
public interface AgentListRepository extends JpaRepository<AgentList, Long> {
	
	@Query(value = "SELECT  *  FROM [TVFUserWiseAgentsLists] (?1) ORDER bY agentno OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY ", nativeQuery = true)
	public List<AgentList> TVFUserWiseAgentsLists(String UId, int offSet , int limit);
	
	@Query(value = "SELECT  count (*)  FROM [TVFUserWiseAgentsLists] (?1)", nativeQuery = true)
	public Integer getCountForAgentList(String UId);
	
	@Query(value = "select Cid from tblCAmap WHERE AgntTypeId = (select AgID from tblAgType WHERE Agtypes = ?1)", nativeQuery = true)
	public Integer getCidFromAgType(String agType);
	
}
