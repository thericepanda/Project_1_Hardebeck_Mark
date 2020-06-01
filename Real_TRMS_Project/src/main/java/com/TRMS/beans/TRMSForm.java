package com.TRMS.beans;

import java.sql.Timestamp;

public class TRMSForm {
	
	private int formID;
	private int empID;
	private String firstName;
	private String lastName;
	private String email;
	private String type;
	private String eventType;
	private String time;
	private Timestamp eventTime;
	private String location;
	private String description;
	private float cost;
	private float rmbrsmntAmt;
	private float empAvailAmt;
	private String gradeFormat;
	private String justification;
	private String directSupervisorApproval;
	private String departmentHeadApproval;
	private String benCoApproval;
	private String rejectionReason;
	private String department;
	private String branch;
	
	public TRMSForm() {
		super();
	}
	
	

	public TRMSForm(int formID, int empID, String firstName, String lastName, String email, String type,
			String eventType, String time, Timestamp eventTime, String location, String description, float cost,
			float rmbrsmntAmt, float empAvailAmt, String gradeFormat, String justification,
			String directSupervisorApproval, String departmentHeadApproval, String benCoApproval,
			String rejectionReason, String department, String branch) {
		super();
		this.formID = formID;
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.eventType = eventType;
		this.time = time;
		this.eventTime = eventTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.rmbrsmntAmt = rmbrsmntAmt;
		this.empAvailAmt = empAvailAmt;
		this.gradeFormat = gradeFormat;
		this.justification = justification;
		this.directSupervisorApproval = directSupervisorApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.benCoApproval = benCoApproval;
		this.rejectionReason = rejectionReason;
		this.department = department;
		this.branch = branch;
	}



	@Override
	public String toString() {
		return "TRMSForm [formID=" + formID + ", empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", type=" + type + ", eventType=" + eventType + ", time=" + time + ", eventTime="
				+ eventTime + ", location=" + location + ", description=" + description + ", cost=" + cost
				+ ", rmbrsmntAmt=" + rmbrsmntAmt + ", empAvailAmt=" + empAvailAmt + ", gradeFormat=" + gradeFormat
				+ ", justification=" + justification + ", directSupervisorApproval=" + directSupervisorApproval
				+ ", departmentHeadApproval=" + departmentHeadApproval + ", benCoApproval=" + benCoApproval
				+ ", rejectionReason=" + rejectionReason + ", department=" + department + ", branch=" + branch + "]";
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public float getRmbrsmntAmt() {
		return rmbrsmntAmt;
	}
	public void setRmbrsmntAmt(float rmbrsmntAmt) {
		this.rmbrsmntAmt = rmbrsmntAmt;
	}

	public float getEmpAvailAmt() {
		return empAvailAmt;
	}

	public void setEmpAvailAmt(float empAvailAmt) {
		this.empAvailAmt = empAvailAmt;
	}


	public Timestamp getEventTime() {
		return eventTime;
	}

	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
	}

	public String getDirectSupervisorApproval() {
		return directSupervisorApproval;
	}

	public void setDirectSupervisorApproval(String directSupervisorApproval) {
		this.directSupervisorApproval = directSupervisorApproval;
	}

	public String getDepartmentHeadApproval() {
		return departmentHeadApproval;
	}

	public void setDepartmentHeadApproval(String departmentHeadApproval) {
		this.departmentHeadApproval = departmentHeadApproval;
	}

	public String getBenCoApproval() {
		return benCoApproval;
	}

	public void setBenCoApproval(String benCoApproval) {
		this.benCoApproval = benCoApproval;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
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




	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public String getGradeFormat() {
		return gradeFormat;
	}


	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}


	public String getJustification() {
		return justification;
	}


	public void setJustification(String justification) {
		this.justification = justification;
	}



	
}
