package com.exide.sfcrm.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="exidereportdataupdate")
public class ExideReportDataUpdate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -527252327151675311L;

	@Id
	@Column(name="ContestID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer contestId;
	
	@Column(name="[Contest Name]")
	private String contestName;
	
	@Column(name="[Agent No]")
	private String agentNo;
	
	@Column(name="DOJ")
	private String DOJ;
	
	@Column(name="DOT")
	private String DOT;
	
	@Column(name="Period")
	private String period;
	
	@Column(name="Start_Date")
	private Date startDate;
	
	@Column(name="End_Date")
	private Date endDate;
	
	@Column(name="AgType")
	private String agType;
	
	@Column(name="LoadDate")
	private Date loadDate;
	
	@Column(name="[ContestName]")
	private String contestName_1;
	
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
	
	@Column(name="[6]")
	private String _6;
	
	@Column(name="[7]")
	private String _7;
	
	@Column(name="[8]")
	private String _8;
	
	@Column(name="[9]")
	private String _9;
	
	@Column(name="[10]")
	private String _10;
	
	@Column(name="[11]")
	private String _11;
	
	@Column(name="[12]")
	private String _12;
	
	@Column(name="[13]")
	private String _13;
	
	@Column(name="[14]")
	private String _14;
	
	@Column(name="[15]")
	private String _15;
	
	@Column(name="[16]")
	private String _16;
	
	@Column(name="[17]")
	private String _17;
	
	@Column(name="[18]")
	private String _18;
	
	@Column(name="[19]")
	private String _19;
	
	@Column(name="[20]")
	private String _20;
	
	@Column(name="[21]")
	private String _21;
	
	@Column(name="[22]")
	private String _22;
	
	@Column(name="[23]")
	private String _23;
	
	@Column(name="[24]")
	private String _24;
	
	@Column(name="[25]")
	private String _25;
	
	@Column(name="[26]")
	private String _26;
	
	@Column(name="[27]")
	private String _27;
	
	@Column(name="[28]")
	private String _28;
	
	@Column(name="[29]")
	private String _29;
	
	@Column(name="[30]")
	private String _30;
	
	@Column(name="[31]")
	private String _31;
	
	@Column(name="[32]")
	private String _32;
	
	@Column(name="[33]")
	private String _33;
	
	@Column(name="[34]")
	private String _34;
	
	@Column(name="[35]")
	private String _35;

	/**
	 * @return this. the contestId
	 */
	public Integer getContestId() {
		return this. contestId;
	}

	/**
	 * @param contestId the contestId to set
	 */
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	/**
	 * @return this. the contestName
	 */
	public String getContestName() {
		return this. contestName;
	}

	/**
	 * @param contestName the contestName to set
	 */
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	/**
	 * @return this. the agentNo
	 */
	public String getAgentNo() {
		return this. agentNo;
	}

	/**
	 * @param agentNo the agentNo to set
	 */
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	/**
	 * @return this. the dOJ
	 */
	public String getDOJ() {
		return this. DOJ;
	}

	/**
	 * @param dOJ the dOJ to set
	 */
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	/**
	 * @return this. the dOT
	 */
	public String getDOT() {
		return this. DOT;
	}

	/**
	 * @param dOT the dOT to set
	 */
	public void setDOT(String dOT) {
		DOT = dOT;
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
	 * @return this. the startDate
	 */
	public Date getStartDate() {
		return this. startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return this. the endDate
	 */
	public Date getEndDate() {
		return this. endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return this. the agType
	 */
	public String getAgType() {
		return this. agType;
	}

	/**
	 * @param agType the agType to set
	 */
	public void setAgType(String agType) {
		this.agType = agType;
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
	 * @return this. the _6
	 */
	public String get_6() {
		return this. _6;
	}

	/**
	 * @param _6 the _6 to set
	 */
	public void set_6(String _6) {
		this._6 = _6;
	}

	/**
	 * @return this. the _7
	 */
	public String get_7() {
		return this. _7;
	}

	/**
	 * @param _7 the _7 to set
	 */
	public void set_7(String _7) {
		this._7 = _7;
	}

	/**
	 * @return this. the _8
	 */
	public String get_8() {
		return this. _8;
	}

	/**
	 * @param _8 the _8 to set
	 */
	public void set_8(String _8) {
		this._8 = _8;
	}

	/**
	 * @return this. the _9
	 */
	public String get_9() {
		return this. _9;
	}

	/**
	 * @param _9 the _9 to set
	 */
	public void set_9(String _9) {
		this._9 = _9;
	}

	/**
	 * @return this. the _10
	 */
	public String get_10() {
		return this. _10;
	}

	/**
	 * @param _10 the _10 to set
	 */
	public void set_10(String _10) {
		this._10 = _10;
	}

	/**
	 * @return this. the _11
	 */
	public String get_11() {
		return this. _11;
	}

	/**
	 * @param _11 the _11 to set
	 */
	public void set_11(String _11) {
		this._11 = _11;
	}

	/**
	 * @return this. the _12
	 */
	public String get_12() {
		return this. _12;
	}

	/**
	 * @param _12 the _12 to set
	 */
	public void set_12(String _12) {
		this._12 = _12;
	}

	/**
	 * @return this. the _13
	 */
	public String get_13() {
		return this. _13;
	}

	/**
	 * @param _13 the _13 to set
	 */
	public void set_13(String _13) {
		this._13 = _13;
	}

	/**
	 * @return this. the _14
	 */
	public String get_14() {
		return this. _14;
	}

	/**
	 * @param _14 the _14 to set
	 */
	public void set_14(String _14) {
		this._14 = _14;
	}

	/**
	 * @return this. the _15
	 */
	public String get_15() {
		return this. _15;
	}

	/**
	 * @param _15 the _15 to set
	 */
	public void set_15(String _15) {
		this._15 = _15;
	}

	/**
	 * @return this. the _16
	 */
	public String get_16() {
		return this. _16;
	}

	/**
	 * @param _16 the _16 to set
	 */
	public void set_16(String _16) {
		this._16 = _16;
	}

	/**
	 * @return this. the _17
	 */
	public String get_17() {
		return this. _17;
	}

	/**
	 * @param _17 the _17 to set
	 */
	public void set_17(String _17) {
		this._17 = _17;
	}

	/**
	 * @return this. the _18
	 */
	public String get_18() {
		return this. _18;
	}

	/**
	 * @param _18 the _18 to set
	 */
	public void set_18(String _18) {
		this._18 = _18;
	}

	/**
	 * @return this. the _19
	 */
	public String get_19() {
		return this. _19;
	}

	/**
	 * @param _19 the _19 to set
	 */
	public void set_19(String _19) {
		this._19 = _19;
	}

	/**
	 * @return this. the _20
	 */
	public String get_20() {
		return this. _20;
	}

	/**
	 * @param _20 the _20 to set
	 */
	public void set_20(String _20) {
		this._20 = _20;
	}

	/**
	 * @return this. the _21
	 */
	public String get_21() {
		return this. _21;
	}

	/**
	 * @param _21 the _21 to set
	 */
	public void set_21(String _21) {
		this._21 = _21;
	}

	/**
	 * @return this. the _22
	 */
	public String get_22() {
		return this. _22;
	}

	/**
	 * @param _22 the _22 to set
	 */
	public void set_22(String _22) {
		this._22 = _22;
	}

	/**
	 * @return this. the _23
	 */
	public String get_23() {
		return this. _23;
	}

	/**
	 * @param _23 the _23 to set
	 */
	public void set_23(String _23) {
		this._23 = _23;
	}

	/**
	 * @return this. the _24
	 */
	public String get_24() {
		return this. _24;
	}

	/**
	 * @param _24 the _24 to set
	 */
	public void set_24(String _24) {
		this._24 = _24;
	}

	/**
	 * @return this. the _25
	 */
	public String get_25() {
		return this. _25;
	}

	/**
	 * @param _25 the _25 to set
	 */
	public void set_25(String _25) {
		this._25 = _25;
	}

	/**
	 * @return this. the _26
	 */
	public String get_26() {
		return this. _26;
	}

	/**
	 * @param _26 the _26 to set
	 */
	public void set_26(String _26) {
		this._26 = _26;
	}

	/**
	 * @return this. the _27
	 */
	public String get_27() {
		return this. _27;
	}

	/**
	 * @param _27 the _27 to set
	 */
	public void set_27(String _27) {
		this._27 = _27;
	}

	/**
	 * @return this. the _28
	 */
	public String get_28() {
		return this. _28;
	}

	/**
	 * @param _28 the _28 to set
	 */
	public void set_28(String _28) {
		this._28 = _28;
	}

	/**
	 * @return this. the _29
	 */
	public String get_29() {
		return this. _29;
	}

	/**
	 * @param _29 the _29 to set
	 */
	public void set_29(String _29) {
		this._29 = _29;
	}

	/**
	 * @return this. the _30
	 */
	public String get_30() {
		return this. _30;
	}

	/**
	 * @param _30 the _30 to set
	 */
	public void set_30(String _30) {
		this._30 = _30;
	}

	/**
	 * @return this. the _31
	 */
	public String get_31() {
		return this. _31;
	}

	/**
	 * @param _31 the _31 to set
	 */
	public void set_31(String _31) {
		this._31 = _31;
	}

	/**
	 * @return this. the _32
	 */
	public String get_32() {
		return this. _32;
	}

	/**
	 * @param _32 the _32 to set
	 */
	public void set_32(String _32) {
		this._32 = _32;
	}

	/**
	 * @return this. the _33
	 */
	public String get_33() {
		return this. _33;
	}

	/**
	 * @param _33 the _33 to set
	 */
	public void set_33(String _33) {
		this._33 = _33;
	}

	/**
	 * @return this. the _34
	 */
	public String get_34() {
		return this. _34;
	}

	/**
	 * @param _34 the _34 to set
	 */
	public void set_34(String _34) {
		this._34 = _34;
	}

	/**
	 * @return this. the _35
	 */
	public String get_35() {
		return this. _35;
	}

	/**
	 * @param _35 the _35 to set
	 */
	public void set_35(String _35) {
		this._35 = _35;
	}

	/**
	 * @return the loadDate
	 */
	public Date getLoadDate() {
		return this.loadDate;
	}

	/**
	 * @param loadDate the loadDate to set
	 */
	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	/**
	 * @return the contestName_1
	 */
	public String getContestName_1() {
		return this.contestName_1;
	}

	/**
	 * @param contestName_1 the contestName_1 to set
	 */
	public void setContestName_1(String contestName_1) {
		this.contestName_1 = contestName_1;
	}
	
	


}
