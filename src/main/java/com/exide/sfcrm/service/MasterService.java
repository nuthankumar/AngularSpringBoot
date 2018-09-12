package com.exide.sfcrm.service;

import java.util.List;

import com.exide.sfcrm.model.ExideContest;
import com.exide.sfcrm.model.ExideReportDataUpdate;
import com.exide.sfcrm.model.ExideRuleEngine;


public interface MasterService {
	
	
	/**
	 * This method is used to get the ExideContest table details.
	 */
	public List<ExideContest> getExideContest();
	
	/**
	 * This method is used to get the ExideRuleEngine table details.
	 * @return 
	 */
	public List<ExideRuleEngine> getExideRuleEngine();
	
	/**
	 * This method is used to get the ExideReportDataUpdate table details.
	 */
	
	public List<ExideReportDataUpdate> getExideReportDataUpdate();

}
