package com.TRMS.beans;

public class UpdateBean {

	private int formID;
	private String  directSupervisorApproval;
    private String departmentHeadApproval;
    private String benCoApproval;
    private String rejectionReason;
    
    public UpdateBean() {}
    
	public UpdateBean(int formID, String directSupervisorApproval, String departmentHeadApproval, String benCoApproval,
			String rejectionReason) {
		super();
		this.formID = formID;
		this.directSupervisorApproval = directSupervisorApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.benCoApproval = benCoApproval;
		this.rejectionReason = rejectionReason;
	}


	public int getFormID() {
		return formID;
	}


	public void setFormID(int formID) {
		this.formID = formID;
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


	@Override
	public String toString() {
		return "UpdateBean [formID=" + formID + ", directSupervisorApproval=" + directSupervisorApproval
				+ ", departmentHeadApproval=" + departmentHeadApproval + ", benCoApproval=" + benCoApproval
				+ ", rejectionReason=" + rejectionReason + "]";
	}
    
}
