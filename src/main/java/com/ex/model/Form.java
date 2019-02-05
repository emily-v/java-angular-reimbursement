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
@Table(name="ersform")
public class Form {
	
	@Id
	@Column(name="FORMID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int formid;
	
	@Column(name="submitDate")
	private String submitdate;
	
	@Column(name="transDate")
	private String transdate;
	
	@Column(name="exptype")
	private String exptype;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="merchant")
	private String merchant;
	
	@Column(name="status")
	private String status;
	
	@Column(name="resolveDate")
	private String resolvedate;
	
	@Column(name="empId")
	private String empid;
	
	public Form() {
		
	}

	public int getFormid() {
		return formid;
	}

	public void setFormid(int formid) {
		this.formid = formid;
	}

	public String getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(String submitdate) {
		this.submitdate = submitdate;
	}

	public String getTransdate() {
		return transdate;
	}

	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	public String getExpType() {
		return exptype;
	}

	public void setExpType(String exptype) {
		this.exptype = exptype;
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

	public String getResolvedate() {
		return resolvedate;
	}

	public void setResolvedate(String resolvedate) {
		this.resolvedate = resolvedate;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	@Override
	public String toString() {
		return "Form [formid=" + formid + ", submitdate=" + submitdate + ", transdate=" + transdate + ", exptype="
				+ exptype + ", amount=" + amount + ", merchant=" + merchant + ", status=" + status + ", resolvedate="
				+ resolvedate + ", empid=" + empid + "]";
	}
	
}

