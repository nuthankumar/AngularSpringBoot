package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="agentlistview")
public class AgentListView {

	@Column(name = "agentname")
	private String agentName;

	@Column(name = "agtype")
	private String agType;
	
	@Column(name="agentnumbername")
	private String agentNumberName;
	
	@EmbeddedId
	AgentListKey agentListKey;

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
	 * @return the agType
	 */
	public String getAgType() {
		return agType;
	}

	/**
	 * @param agType the agType to set
	 */
	public void setAgType(String agType) {
		this.agType = agType;
	}

	/**
	 * @return the agentListKey
	 */
	public AgentListKey getAgentListKey() {
		return agentListKey;
	}

	/**
	 * @param agentListKey the agentListKey to set
	 */
	public void setAgentListKey(AgentListKey agentListKey) {
		this.agentListKey = agentListKey;
	}

	/**
	 * @return the agentNumberName
	 */
	public String getAgentNumberName() {
		return agentNumberName;
	}

	/**
	 * @param agentNumberName the agentNumberName to set
	 */
	public void setAgentNumberName(String agentNumberName) {
		this.agentNumberName = agentNumberName;
	}
	
	
	
	
}
