package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.model.AgentMaster;
import com.exide.sfcrm.repository.AgentMasterRepository;
import com.exide.sfcrm.service.AgentMasterService;
/**
 * 
 * @author vasavivr
 *
 */
@Service
public class AgentMasterServiceImpl implements AgentMasterService{

	@Autowired
	private AgentMasterRepository agentMasterRepository;
	
	@Override
	public List<AgentMaster> getAgentMaster() {
		// TODO Auto-generated method stub
		List<AgentMaster> agentMasters=new ArrayList<>();
		agentMasterRepository.findAll().forEach(e->agentMasters.add(e));
		return agentMasters;
	}
	

}
