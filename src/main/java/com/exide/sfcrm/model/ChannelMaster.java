package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblchannelmaster")
public class ChannelMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1791704146331070315L;

	/**
	 * 
	 */


	@Id
	@Column(name = "cid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	@Column(name = "chanelname")
	private String chanelName;

	@Column(name = "description")
	private String description;
	
	@Column(name="status")
	private boolean status;

	/**
	 * @return the cid
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * @return the chanelName
	 */
	public String getChanelName() {
		return chanelName;
	}

	/**
	 * @param chanelName the chanelName to set
	 */
	public void setChanelName(String chanelName) {
		this.chanelName = chanelName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
