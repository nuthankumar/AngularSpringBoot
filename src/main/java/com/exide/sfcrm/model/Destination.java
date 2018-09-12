package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author vasavivr
 *
 */

@Entity
@Table(name = "tbldestinationplace")
public class Destination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4331339000342257543L;

	@Id
	@Column(name = "transautoid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transAutoId;


	@Column(name = "destid", unique = true)
	private Integer destID;

	@Column(name = "destname")
	private String destName;

	@Column(name = "destdescrp", nullable = true)
	private String destDescrp;

	public Integer getTransAutoId() {
		return transAutoId;
	}

	public void setTransAutoId(Integer transAutoId) {
		this.transAutoId = transAutoId;
	}

	public Integer getDestID() {
		return destID;
	}

	public void setDestID(Integer destID) {
		this.destID = destID;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	public String getDestDescrp() {
		return destDescrp;
	}

	public void setDestDescrp(String destDescrp) {
		this.destDescrp = destDescrp;
	}

}
