package com.exide.sfcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.ChannelType;

@Repository
public interface Channel_TypeRepository extends JpaRepository<ChannelType, Long>{
	@Query(value = "select name from channel_type where cost_center_id = ?1", nativeQuery=true)
	public String getChannelBasedOnCostCenter(Integer costCenter);
	

}
