package com.ex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// establishing a table in the database for reimbursement forms and giving it a name and properties 
// using encapsulation (private data known as data-binding / public methods to get and set the values)

@Entity
@Table(name="ersforms")
public class Form {
	
	@Id
	@Column(name="formId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int formId;
	
	@Column(name="submitDate")
	private String submitDate;
	
	@Column(name="transDate")
	private String transDate;
	
	@Column(name="exptype")
	private String expType;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="merchant")
	private String merchant;
	
	@Column(name="status")
	private String status;
	
	@Column(name="resolveDate")
	private String resolveDate;
	
	@Column(name="userId")
	private int userId;
	
	public Form() {
		
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Form{" +
				"formId=" + formId +
				", submitDate='" + submitDate + '\'' +
				", transDate='" + transDate + '\'' +
				", expType='" + expType + '\'' +
				", amount=" + amount +
				", merchant='" + merchant + '\'' +
				", status='" + status + '\'' +
				", resolveDate='" + resolveDate + '\'' +
				", userId=" + userId +
				'}';
	}
}

