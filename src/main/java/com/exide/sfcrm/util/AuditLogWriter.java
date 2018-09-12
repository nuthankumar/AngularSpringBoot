package com.exide.sfcrm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.exide.sfcrm.dao.AuditLogDetailDao;
import com.exide.sfcrm.model.AuditLogDetails;
import com.exide.sfcrm.util.LoggerUtils;

/**
 * @author saurabhp
 *
 */
@Component
public class AuditLogWriter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuditLogWriter.class);

	@Autowired
	private AuditLogDetailDao dao;

	@Async
	public void write(AuditLogDetails activityLog) {
		try {
			dao.save(activityLog);
			
		} catch (Exception exc) {
			LOGGER.error(
					"Error writing activity log for {} with result {} to Database"+exc,
					activityLog.getAuditName(),
					activityLog.getAuditResult(), exc);
		}
		LOGGER.info("Activity -> {} ", LoggerUtils.asString(activityLog));
	}
}
