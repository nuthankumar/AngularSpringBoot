package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

import com.exide.sfcrm.model.Reasons;



public interface ReasonsService {

	List<Reasons> getReasonList();

	Reasons addReasons(Reasons reason);

	Reasons updateReasonList(Reasons reason);

	Integer updateStatus(List<Map<String, String>> json);



}
