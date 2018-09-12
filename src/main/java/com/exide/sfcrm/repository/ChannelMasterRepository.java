package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.ChannelMaster;
/**
 * 
 * @author vasavivr
 *
 */

@Repository
public interface ChannelMasterRepository extends JpaRepository<ChannelMaster, Integer>{
	
	@Query(value="SELECT * FROM [TVFUserWiseChannels] (?1,?2)",nativeQuery=true)
	public Integer getCounts(boolean status, String userId);

	
	@Query(value="SELECT cid,chanelName,description,1 as Status FROM [TVFUserWiseChannels] (?1,?2) ORDER by cid OFFSET (?3)  ROWS FETCH NEXT (?4) ROWS ONLY",nativeQuery=true)
	public List<ChannelMaster> getChannelList(boolean status, String userId,
			Integer offset, Integer limit);
	
	


}
