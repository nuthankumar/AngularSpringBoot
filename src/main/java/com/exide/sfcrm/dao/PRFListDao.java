/**
 * 
 */
package com.exide.sfcrm.dao;

import java.util.List;

import com.exide.sfcrm.model.PRFListCashView;

/**
 * @author neethub
 *
 */
public interface PRFListDao {
	
	/**
	 * This method is used to insert the PRFList for type cash into temporary table.
	 * @param prfCashList
	 */
	public void insertTmpPFRCashData(List<PRFListCashView> prfCashList);

}
