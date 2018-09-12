/**
 * 
 */
package com.exide.sfcrm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.dao.PRFListDao;
import com.exide.sfcrm.model.PRFListCashView;

/**
 * @author neethub
 *
 */
@Repository
@Transactional
public class PRFListDaoImpl implements PRFListDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertTmpPFRCashData(List<PRFListCashView> prfCashList) {
		Session session = null;
		try{
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			for (PRFListCashView prfListCashAdvanceView : prfCashList) {
				session.save(prfListCashAdvanceView);
			}
			transaction.commit();
			session.flush();
		}catch(Exception ex){
			
		}
		
	}

}
