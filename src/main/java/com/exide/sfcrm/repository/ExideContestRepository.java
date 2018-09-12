package com.exide.sfcrm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.ExideContest;

/**
 * @author neethub
 *
 */
@Repository
public interface ExideContestRepository extends CrudRepository<ExideContest, Long> {
	
	@Override
	public Iterable<ExideContest> findAll();
	
	@Query(value = "EXEC [getData] ", nativeQuery = true)
	@Modifying
	@Transactional
	public void getDataIntoTables() throws Exception;

	@Query(value = "EXEC [callidusRun] ", nativeQuery = true)
	@Modifying
	@Transactional
	public void callidusRun() throws Exception;


	

}
