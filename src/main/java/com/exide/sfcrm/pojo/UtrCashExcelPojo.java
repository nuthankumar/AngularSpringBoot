package com.exide.sfcrm.pojo;

import org.springframework.stereotype.Component;
/**
 * 
 * @author vasavivr
 *
 */

@Component
public class UtrCashExcelPojo {
	
	
	private String prfNo;
	private String agentNo;
	private String agentName;
	private double netPayout;
	private String utrNo;
	private String transferDate;
	/**
	 * @return the prfNo
	 */
	public String getPrfNo() {
		return prfNo;
	}
	/**
	 * @param prfNo the prfNo to set
	 */
	public void setPrfNo(String prfNo) {
		this.prfNo = prfNo;
	}
	/**
	 * @return the agentNo
	 */
	public String getAgentNo() {
		return agentNo;
	}
	/**
	 * @param agentNo the agentNo to set
	 */
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**
	 * @return the netPayout
	 */
	public double getNetPayout() {
		return netPayout;
	}
	/**
	 * @param d the netPayout to set
	 */
	public void setNetPayout(double d) {
		this.netPayout = d;
	}
	/**
	 * @return the utrNo
	 */
	public String getUtrNo() {
		return utrNo;
	}
	/**
	 * @param utrNo the utrNo to set
	 */
	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}
	/**
	 * @return the transferDate
	 */
	public String getTransferDate() {
		return transferDate;
	}
	/**
	 * @param transferDate the transferDate to set
	 */
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	
	

}	
