package com.exide.sfcrm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="lastupdateview")
public class LastUpdateView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7243097707715670256L;

	
	@Id
	@Column(name="lastcontestupdate")
	private String lastContestUpdate; 
	
	@Column(name="lastagentupdate")
	private String lastAgentUpdate;

	/**
	 * @return the lastContestUpdate
	 */
	public String getLastContestUpdate() {
		return lastContestUpdate;
	}

	/**
	 * @param lastContestUpdate the lastContestUpdate to set
	 */
	public void setLastContestUpdate(String lastContestUpdate) {
		this.lastContestUpdate = lastContestUpdate;
	}

	/**
	 * @return the lastAgentUpdate
	 */
	public String getLastAgentUpdate() {
		return lastAgentUpdate;
	}

	/**
	 * @param lastAgentUpdate the lastAgentUpdate to set
	 */
	public void setLastAgentUpdate(String lastAgentUpdate) {
		this.lastAgentUpdate = lastAgentUpdate;
	} 
	
	
	
}
