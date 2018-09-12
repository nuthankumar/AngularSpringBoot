package com.exide.sfcrm.dao;

import java.util.List;

import com.exide.sfcrm.model.DeviationCashView;
import com.exide.sfcrm.model.DeviationTicketsView;

public interface DeviationListDao {



	void insertTmpDeviationCashData(List<DeviationCashView> cashList);

	void insertTmpDeviationTicketData(
			List<DeviationTicketsView> deviationTicketsList);

}
