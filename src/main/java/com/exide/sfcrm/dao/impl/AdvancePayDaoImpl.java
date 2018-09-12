/**
 * 
 */
package com.exide.sfcrm.dao.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.dao.AdvancePayDao;
import com.exide.sfcrm.model.AdvancePay;
import com.exide.sfcrm.model.AdvancePayCashView;


/**
 * @author saurabhp
 *
 */
@Repository
@Transactional
public class AdvancePayDaoImpl implements AdvancePayDao{
	
	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdvancePayDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AdvancePay createAdvancePay(AdvancePay advancePay) throws Exception {
		// TODO Auto-generated method stub

		LOGGER.debug("Inside create advance pay dao method");

		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(advancePay);
			transaction.commit();
			session.flush();
			LOGGER.debug("Advance pay data saved successfully : " + advancePay.getId());
		} catch(HibernateException e){
			if (null != session && session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			LOGGER.error("Unable to persist data into advance pay table " + e);
			throw e;
		}finally {
			if (null != session) {
				session.close();
			}
		}

		return advancePay;

	}


	public void insertTmpAdvancePayCash(List<AdvancePayCashView> advancePayList) {
	
		Session session=null;
		try{
			session=this.sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
		for(AdvancePayCashView advancePayCashView :advancePayList ){
			session.save(advancePayCashView);
		}
		transaction.commit();
		session.flush();
		LOGGER.debug("Advance pay data saved successfully : ");
		}
		 catch(HibernateException e){
				if (null != session && session.getTransaction() != null) {
					session.getTransaction().rollback();
				}
				LOGGER.error("Unable to persist data into advance pay table " + e);
				throw e;
			}finally {
				if (null != session) {
					session.close();
				}
			}
	}


	@Override
	public void insertTmpAdvancePayCheckerCash(
			List<AdvancePayCashView> advancePayCheckerList) {
		
		Session session=null;
		try{
			session=this.sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
		for(AdvancePayCashView advancePayCashView :advancePayCheckerList ){
			session.save(advancePayCashView);
		}
		transaction.commit();
		session.flush();
		LOGGER.debug("Advance pay data saved successfully : ");
		}
		catch(Exception ex){
			
		}
	}



}
