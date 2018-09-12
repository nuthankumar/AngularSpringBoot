package com.exide.sfcrm.service;


import java.util.List;
import java.util.Map;

import com.exide.sfcrm.model.ContestView;
import com.exide.sfcrm.model.ContestsDrpView;
import com.exide.sfcrm.model.LastUpdateView;
import com.exide.sfcrm.model.TripDetailsView;

/**
 * 
 * @author vasavivr
 *
 */
public interface ContestMasterService  {

	/**
	 * This method is used to get the ContestMaster table details.
	 * @param limit 
	 * @param  
	 */
     public	Map<String, Object> getContestMaster(Integer pageNumber , Integer limit);

	
	public Map<String, Object> getChannelList(boolean status, String userId,
			Integer pageNumber, Integer limit);




	public void addContest(List<Map<String, String>> json, String userId);


	public Map<String, Object> getContestMasterWithTripDetails();


	public List<ContestView> getAllContests();


	public List<ContestsDrpView> getAllContestsDrp();


	public List<LastUpdateView> getlastUpdateDate();


	public List<TripDetailsView> getTripDetails(Integer contestId);





	





}
