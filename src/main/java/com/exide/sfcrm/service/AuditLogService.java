/**
 * 
 */
package com.exide.sfcrm.service;

import com.exide.sfcrm.model.AuditLogDetails;


/**
 * @author saurabhp
 *
 */
public interface AuditLogService {
	
	public void addActivity(String activityName, String activityResult, String comments,
			String data, String userName);
	
	public void save(AuditLogDetails detail);
}
