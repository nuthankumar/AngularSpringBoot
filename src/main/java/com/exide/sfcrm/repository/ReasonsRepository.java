package com.exide.sfcrm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.Reasons;

@Repository
@Transactional
public interface ReasonsRepository extends JpaRepository<Reasons, String> {

	@Modifying
	@Query(value = "UPDATE Reasons SET status=?1 where code=?2 ", nativeQuery = true)
	Integer updateStatus(Boolean status, String code);

}
