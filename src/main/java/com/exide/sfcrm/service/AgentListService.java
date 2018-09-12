package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

import com.exide.sfcrm.model.AgentList;
import com.exide.sfcrm.model.AgentListView;

/**
 * 
 * @author vasavivr
 *
 */
public interface AgentListService {
	/**
	 * This method is used to get the AgentList
	 * @param userName
	 * @return
	 */

	 Map<String,Object> getAgentList(String userName, int pageNumber, int limit);

	List<AgentListView> getAgents(String string);

}
