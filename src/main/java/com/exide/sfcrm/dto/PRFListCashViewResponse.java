package com.exide.sfcrm.dto;

public class PRFListCashViewResponse {

	private PRFListCashKeyResponse prfListCashKey;
	
	public PRFListCashViewResponse(PRFListCashKeyResponse prfListCashKey) {
		this.prfListCashKey = prfListCashKey;
	}
	public PRFListCashKeyResponse getPrfListCashKey() {
		return prfListCashKey;
	}

	public void setPrfListCashKey(PRFListCashKeyResponse prfListCashKey) {
		this.prfListCashKey = prfListCashKey;
	}
}
