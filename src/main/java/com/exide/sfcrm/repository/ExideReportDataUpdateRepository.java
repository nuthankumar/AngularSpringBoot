package com.exide.sfcrm.repository;

import org.springframework.data.repository.CrudRepository;

import com.exide.sfcrm.model.ExideReportDataUpdate;

public interface ExideReportDataUpdateRepository extends CrudRepository<ExideReportDataUpdate, Long>{
	
	@Override
	public Iterable<ExideReportDataUpdate> findAll();

}
