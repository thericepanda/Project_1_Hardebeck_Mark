package com.TRMS.beans;

public class Messages {
	private int formID;
	private int empID;
	private float oldAmt;
	private float newAmt;
	private int urgent;
	private int response;
	private String additionalInfo;
	
	public Messages() {}
	
	public Messages(int formID, int empID, float oldAmt, float newAmt, int urgent, int response,
			String additionalInfo) {
		super();
		this.formID = formID;
		this.empID = empID;
		this.oldAmt = oldAmt;
		this.newAmt = newAmt;
		this.urgent = urgent;
		this.response = response;
		this.additionalInfo = additionalInfo;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public float getOldAmt() {
		return oldAmt;
	}

	public void setOldAmt(float oldAmt) {
		this.oldAmt = oldAmt;
	}

	public float getNewAmt() {
		return newAmt;
	}

	public void setNewAmt(float newAmt) {
		this.newAmt = newAmt;
	}

	public int getUrgent() {
		return urgent;
	}

	public void setUrgent(int urgent) {
		this.urgent = urgent;
	}

	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "Messages [formID=" + formID + ", empID=" + empID + ", oldAmt=" + oldAmt + ", newAmt=" + newAmt
				+ ", urgent=" + urgent + ", response=" + response + ", additionalInfo=" + additionalInfo + "]";
	}
}
