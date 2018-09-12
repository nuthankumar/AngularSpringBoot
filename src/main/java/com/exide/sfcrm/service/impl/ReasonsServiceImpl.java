package com.exide.sfcrm.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.model.Reasons;
import com.exide.sfcrm.repository.ReasonsRepository;
import com.exide.sfcrm.service.ReasonsService;

@Service
public class ReasonsServiceImpl implements ReasonsService {

	@Autowired
	ReasonsRepository reasonsRepository;

	@Override
	public List<Reasons>getReasonList() {
		return reasonsRepository.findAll();
	}

	@Override
	public Reasons addReasons(Reasons reason) {
		return reasonsRepository.save(reason);
	}

	@Override
	public Reasons updateReasonList(Reasons reason) {
		return reasonsRepository.saveAndFlush(reason);
	}

	@Override
	public Integer updateStatus(List<Map<String, String>> json) {
		
		Integer response = 0;
		String status = null;
		String code = null;
		for (Map<String, String> rows : json) {
			status = rows.get("status");
			code = rows.get("code");
			response = reasonsRepository.updateStatus(Boolean.valueOf(status),code);
		}
		return response;
	}


}
