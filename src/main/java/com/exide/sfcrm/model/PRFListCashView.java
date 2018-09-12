package com.exide.sfcrm.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "tmptblprflistcash")
public class PRFListCashView {
	
	@EmbeddedId
	private PRFListCashKey prfListCashKey;

	/**
	 * @return the prfListCashKey
	 */
	public PRFListCashKey getPrfListCashKey() {
		return prfListCashKey;
	}

	/**
	 * @param prfListCashKey the prfListCashKey to set
	 */
	public void setPrfListCashKey(PRFListCashKey prfListCashKey) {
		this.prfListCashKey = prfListCashKey;
	}
	
	@Override
	public boolean equals(Object obj) {
		PRFListCashView view = (PRFListCashView) obj;
		return view.getPrfListCashKey().getAdvancePayout().intValue() == this.prfListCashKey.getAdvancePayout().intValue() &&
				view.getPrfListCashKey().getNetPayout().intValue() == this.prfListCashKey.getNetPayout().intValue() && 
				view.getPrfListCashKey().getTransAutoId().intValue() == this.prfListCashKey.getTransAutoId().intValue() && 
				view.getPrfListCashKey().getAgentNo().equals(this.prfListCashKey.getAgentNo()) && 
				view.getPrfListCashKey().getDeviationAmt().intValue() == this.prfListCashKey.getDeviationAmt().intValue() && 
				view.getPrfListCashKey().getAdvanceRecoverable().intValue() == this.prfListCashKey.getAdvanceRecoverable().intValue() &&
				view.getPrfListCashKey().getNetAmount().intValue() == this.prfListCashKey.getNetAmount().intValue();
				
	}
	
	@Override
	public int hashCode() {
		
		return  prfListCashKey.getTransAutoId().intValue() + Integer.parseInt(prfListCashKey.getAgentNo()) + 
				prfListCashKey.getNetPayout().intValue() + prfListCashKey.getAdvancePayout().intValue() +
				prfListCashKey.getDeviationAmt().intValue() + prfListCashKey.getAdvanceRecoverable().intValue() +
				prfListCashKey.getNetAmount().intValue() + prfListCashKey.getAgType();
	}

}
