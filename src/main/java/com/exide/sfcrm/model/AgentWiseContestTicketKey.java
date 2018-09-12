package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AgentWiseContestTicketKey implements Serializable {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2301654211863534316L;

	@Column(name="agentno")
	private String agentNo;
	
	@Column(name = "[Option]")
	private String option;

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
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}
	
	
	
}
