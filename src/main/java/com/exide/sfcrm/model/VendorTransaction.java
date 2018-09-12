package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Vendor_Transaction")
public class VendorTransaction implements Serializable {

	private static final long serialVersionUID = 1469173630793216170L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_Transaction_Id")
	private Integer vendorTransactionId;

	@OneToOne
	@JoinColumn(name = "cost_Center_Id")
	private CostCenter costCenter;

	@Column(name = "channel_Type")
	private String channelType;

	@Column(name = "vendor_Name")
	private String vendorName;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "tax")
	private String tax;

	@Column(name = "net_Payable")
	private Double netPayable;

	@Column(name = "amount_In_Words")
	private String amountInWords;

	@Column(name = "mode_Of_Payment")
	private String modeOfPayment;

	 //@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date")
     private String date;

	public Integer getVendorTransactionId() {
		return vendorTransactionId;
	}

	public void setVendorTransactionId(Integer vendorTransactionId) {
		this.vendorTransactionId = vendorTransactionId;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getAmountInWords() {
		return amountInWords;
	}

	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(Double netPayable) {
		this.netPayable = netPayable;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

}
