package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.LastUpdateView;

@Repository
public interface LastUpdateViewRepository extends
		JpaRepository<LastUpdateView, Integer> {

	@Query(value = " EXEC [LastUpdateDate] ", nativeQuery = true)
	List<LastUpdateView> executeLastUpdate();
}
