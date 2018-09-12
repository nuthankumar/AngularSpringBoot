package com.exide.sfcrm.service;

import java.util.List;

import com.exide.sfcrm.model.AgentGregList;
import com.exide.sfcrm.model.AgentGregListView;


public interface AgentGregListService {

	List<AgentGregListView> getAgentGregList();

	AgentGregList addAgentGregList(AgentGregList agentGregList);

	AgentGregList updateAgentGregList(AgentGregList agentGregList);

}
