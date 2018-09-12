package com.exide.sfcrm.repository;

import org.springframework.data.repository.CrudRepository;

import com.exide.sfcrm.model.ExideRuleEngine;

public interface ExideRuleEngineRepository extends CrudRepository<ExideRuleEngine, Long>{
	
	@Override
	public Iterable<ExideRuleEngine> findAll();

}
