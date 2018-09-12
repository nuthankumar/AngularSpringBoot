
package com.exide.sfcrm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.model.AuditLogDetails;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.util.AuditLogWriter;
import com.exide.sfcrm.util.DateUtils;


/**
 * @author saurabhp
 *
 */
@Service
public class AuditLogServiceImpl implements AuditLogService{
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuditLogServiceImpl.class);

	@Autowired
	private AuditLogWriter writer;
	
	/**
	 * Adds an activity that is not related to a transaction or policy number
	 * 
	 * @param activity
	 *            The activity performed
	 * @param description
	 *            The description of the activity
	 * @param result
	 *            The status (result) of the activity
	 * @param info
	 *            Any additional information. This information will be
	 *            serialized and saved with the activity log
	 */
	
	@Override
	public void addActivity(String activityName, String activityResult,
			String comments, String data, String userName) {

		AuditLogDetails detail = createActivityLogDetail(activityName, activityResult, comments, data, userName);

		save(detail);
	}
	
	
	private AuditLogDetails createActivityLogDetail(String activityName, String activityResult,
			String comments, String data, String userName) {

		AuditLogDetails detail = new AuditLogDetails();

		// Add the parameters
		detail.setAuditName(activityName);
		detail.setAuditResult(activityResult);
		detail.setComments(comments);
		detail.setUserName(userName);
		detail.setData(data);
		detail.setCreatedDatetime(DateUtils.now());
		detail.setCreatedUser("System");
		detail.setAuditTime(DateUtils.now());

		return detail;
	}
	
	@Override
	public void save(AuditLogDetails detail) {
		LOGGER.trace("Inside save activity detail");
		writer.write(detail);
	}
}
