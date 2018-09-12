package com.exide.sfcrm.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.dao.DeviationListDao;
import com.exide.sfcrm.model.DeviationCashView;
import com.exide.sfcrm.model.DeviationTicketsView;

@Repository
@Transactional
public class DeviationListDaoImpl implements DeviationListDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertTmpDeviationCashData(List<DeviationCashView> cashList) {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			for (DeviationCashView deviationListCashView : cashList) {
				session.save(deviationListCashView);
			}
			transaction.commit();
			session.flush();
		} catch (Exception ex) {

		}

	}

	@Override
	public void insertTmpDeviationTicketData(
			List<DeviationTicketsView> deviationTicketsList) {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			for (DeviationTicketsView deviationListTicketsView : deviationTicketsList) {
				session.save(deviationListTicketsView);
			}
			transaction.commit();
			session.flush();
		} catch (Exception ex) {

		}

	}
		
	}


