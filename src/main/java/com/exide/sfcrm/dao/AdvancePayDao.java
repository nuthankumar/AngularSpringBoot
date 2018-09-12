/**
 * 
 */
package com.exide.sfcrm.dao;

import java.util.List;

import com.exide.sfcrm.model.AdvancePay;
import com.exide.sfcrm.model.AdvancePayCashView;

/**
 * @author saurabhp
 *
 */
public interface AdvancePayDao {


	/**
	 * 
	 * @param user
	 * @throws Exception
	 */
	public AdvancePay createAdvancePay(AdvancePay advancePay) throws Exception;

	public void insertTmpAdvancePayCash(List<AdvancePayCashView> advancePayList);

	public void insertTmpAdvancePayCheckerCash(
			List<AdvancePayCashView> advancePayCheckerList);

}
