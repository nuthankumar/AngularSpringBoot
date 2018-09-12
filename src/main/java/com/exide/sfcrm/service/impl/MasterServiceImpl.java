package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exide.sfcrm.model.ExideContest;
import com.exide.sfcrm.model.ExideReportDataUpdate;
import com.exide.sfcrm.model.ExideRuleEngine;
import com.exide.sfcrm.repository.ExideContestRepository;
import com.exide.sfcrm.repository.ExideReportDataUpdateRepository;
import com.exide.sfcrm.repository.ExideRuleEngineRepository;
import com.exide.sfcrm.service.MasterService;

@Component
public class MasterServiceImpl implements MasterService {

	@Autowired
	ExideContestRepository exideContestRepository;

	@Autowired
	ExideRuleEngineRepository exideRuleEngineRepository;

	@Autowired
	ExideReportDataUpdateRepository exideReportDataUpdateRepository;

	@Override
	public List<ExideContest> getExideContest() {

		List<ExideContest> exideContests = new ArrayList<>();
		exideContestRepository.findAll().forEach(e -> exideContests.add(e));
		return exideContests;
	}

	@Override
	public List<ExideRuleEngine> getExideRuleEngine() {
		List<ExideRuleEngine> exideRuleEngine = new ArrayList<>();
		exideRuleEngineRepository.findAll()
				.forEach(e -> exideRuleEngine.add(e));
		return exideRuleEngine;
	}

	@Override
	public List<ExideReportDataUpdate> getExideReportDataUpdate() {
		List<ExideReportDataUpdate> exideReportDataUpdate = new ArrayList<>();
		exideReportDataUpdateRepository.findAll()
				.forEach(e -> exideReportDataUpdate.add(e));
		return exideReportDataUpdate;

	}

}
