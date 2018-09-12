package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.model.AgentGregList;
import com.exide.sfcrm.model.AgentGregListView;
import com.exide.sfcrm.repository.AgentGregListRepository;
import com.exide.sfcrm.repository.AgentGregListViewRepository;
import com.exide.sfcrm.service.AgentGregListService;

@Service
public class AgentGregListServiceImpl implements AgentGregListService {

	@Autowired
	private AgentGregListRepository agentGregListRepository;
	
	@Autowired
	private AgentGregListViewRepository agentGregListViewRepository;
	
@Override
	public List<AgentGregListView> getAgentGregList() {
		List<AgentGregListView> agentGregList = new ArrayList<AgentGregListView>();
		agentGregList = agentGregListViewRepository.findByAgentName();
		return agentGregList;
	}



	@Override
	public AgentGregList addAgentGregList(AgentGregList agentGregList) {

		return agentGregListRepository.save(agentGregList);
	}

	@Override
	public AgentGregList updateAgentGregList(AgentGregList agentGregList) {

		return agentGregListRepository.saveAndFlush(agentGregList);
	}




	



}
