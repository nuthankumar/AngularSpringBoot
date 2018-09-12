
package com.exide.sfcrm.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AuditLogDetails;
import com.exide.sfcrm.dao.AuditLogDetailDao;


/**
 * @author saurabhp
 *
 */
@Repository
@Transactional
public class AuditLogDetailDaoImpl implements AuditLogDetailDao {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuditLogDetailDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(AuditLogDetails auditLogDetails) {
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.save(auditLogDetails);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			LOGGER.error("Unable to persist data into auditLogDetails table " + e);
	
		} finally {
			session.close();
		}
	}

}
