package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tblgreglistagentnoview")
public class AgentGregListView {

	@Column(name = "agentname")
	private String agentName;

	@EmbeddedId
	AgentGregListKey agentGregListKey;

	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @param agentName
	 *            the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * @return the agentGregListKey
	 */
	public AgentGregListKey getAgentGregListKey() {
		return agentGregListKey;
	}

	/**
	 * @param agentGregListKey the agentGregListKey to set
	 */
	public void setAgentGregListKey(AgentGregListKey agentGregListKey) {
		this.agentGregListKey = agentGregListKey;
	}

}
