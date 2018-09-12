package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author neethub
 *
 */
@Entity
@Table(name="exideruleengine")
public class ExideRuleEngine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2895007367354643032L;
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="Criteria")
	private String criteria;
	
	@Column(name="Period")
	private String period;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="Seq")
	private String seq;
	
	@Column(name="[Rule Name]")
	private String ruleName;
	
	@Column(name="Payable")
	private String payable;
	
	@Column(name="[1]")
	private String _1;
	
	@Column(name="[2]")
	private String _2;
	
	@Column(name="[3]")
	private String _3;
	
	@Column(name="[4]")
	private String _4;
	
	@Column(name="[5]")
	private String _5;

	/**
	 * @return this. the criteria
	 */
	public String getCriteria() {
		return this. criteria;
	}

	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	/**
	 * @return this. the period
	 */
	public String getPeriod() {
		return this. period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return this. the type
	 */
	public String getType() {
		return this. type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return this. the seq
	 */
	public String getSeq() {
		return this. seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return this. the ruleName
	 */
	public String getRuleName() {
		return this. ruleName;
	}

	/**
	 * @param ruleName the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	/**
	 * @return this. the payable
	 */
	public String getPayable() {
		return this. payable;
	}

	/**
	 * @param payable the payable to set
	 */
	public void setPayable(String payable) {
		this.payable = payable;
	}

	/**
	 * @return this. the _1
	 */
	public String get_1() {
		return this. _1;
	}

	/**
	 * @param _1 the _1 to set
	 */
	public void set_1(String _1) {
		this._1 = _1;
	}

	/**
	 * @return this. the _2
	 */
	public String get_2() {
		return this. _2;
	}

	/**
	 * @param _2 the _2 to set
	 */
	public void set_2(String _2) {
		this._2 = _2;
	}

	/**
	 * @return this. the _3
	 */
	public String get_3() {
		return this. _3;
	}

	/**
	 * @param _3 the _3 to set
	 */
	public void set_3(String _3) {
		this._3 = _3;
	}

	/**
	 * @return this. the _4
	 */
	public String get_4() {
		return this. _4;
	}

	/**
	 * @param _4 the _4 to set
	 */
	public void set_4(String _4) {
		this._4 = _4;
	}

	/**
	 * @return this. the _5
	 */
	public String get_5() {
		return this. _5;
	}

	/**
	 * @param _5 the _5 to set
	 */
	public void set_5(String _5) {
		this._5 = _5;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id; 
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


}
