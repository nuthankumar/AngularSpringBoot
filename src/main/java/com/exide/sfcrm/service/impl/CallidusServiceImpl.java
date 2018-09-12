/**
 * 
 */
package com.exide.sfcrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.repository.ExideContestRepository;
import com.exide.sfcrm.service.CallidusService;

/**
 * @author saurabhp
 *
 */
@Service
public class CallidusServiceImpl implements CallidusService{
	
	
	@Autowired
	private ExideContestRepository exideContestRepository;

	/**
	 * Get all data To tables.
	 */
	@Override
	public boolean getDataIntoTables() throws Exception{

		exideContestRepository.getDataIntoTables();
		
		return ApplicationConstants.TRUE;
	}

	@Override
	public boolean callidusRun() throws Exception {
		
		exideContestRepository.callidusRun();
		return ApplicationConstants.TRUE;
	}

}
