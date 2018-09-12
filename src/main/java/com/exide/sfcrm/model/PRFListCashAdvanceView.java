/**
 * 
 */
package com.exide.sfcrm.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author neethub
 *
 */
@Entity
@Table(name = "prflistcashadvanceview")
public class PRFListCashAdvanceView {
	
	@EmbeddedId
	private PRFListCashAdvanceKey prfListCashAdvanceKey;

	/**
	 * @return the prfListCashAdvanceKey
	 */
	public PRFListCashAdvanceKey getPrfListCashAdvanceKey() {
		return prfListCashAdvanceKey;
	}

	/**
	 * @param prfListCashAdvanceKey the prfListCashAdvanceKey to set
	 */
	public void setPrfListCashAdvanceKey(PRFListCashAdvanceKey prfListCashAdvanceKey) {
		this.prfListCashAdvanceKey = prfListCashAdvanceKey;
	}
	

}
