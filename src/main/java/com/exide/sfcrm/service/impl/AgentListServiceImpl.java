package com.exide.sfcrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.AgentList;
import com.exide.sfcrm.model.AgentListView;
import com.exide.sfcrm.repository.AgentListRepository;
import com.exide.sfcrm.repository.AgentListViewRepository;
import com.exide.sfcrm.service.AgentListService;
import com.exide.sfcrm.util.CommonUtil;

/**
 * 
 * @author vasavivr
 *
 */
@Service
public class AgentListServiceImpl implements AgentListService {

	@Autowired
	AgentListRepository agentListRepository;

	@Autowired
	private PropertyConstants propertyConstants;
	
	@Autowired
	private AgentListViewRepository agentListViewRepository;

	@Autowired
	private CommonUtil commonUtil;

	public Map<String, Object> getAgentList(String userName, int pageNumber,
			int limit) {

		List<AgentList> agentList = agentListRepository.TVFUserWiseAgentsLists(
				userName, pageNumber, propertyConstants.PAGE_LIMIT);
		Integer totalNumberOfAgent = agentListRepository
				.getCountForAgentList(userName);

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("agentList", agentList);
		data.put("agentListCount", totalNumberOfAgent);
		return data;
	}

	@Override
	public List<AgentListView> getAgents(String string) {
		List<AgentListView> agents = agentListViewRepository
				.TVFUserWiseAgents("neethub");
		return agents;
	}

}
