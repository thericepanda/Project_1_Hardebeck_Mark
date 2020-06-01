package com.TRMS.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.TRMS.beans.Messages;
import com.TRMS.beans.TRMSForm;
import com.TRMS.beans.UpdateBean;
import com.TRMS.util.ConnFactory;

public class TRMSFormDAOImpl{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public List<TRMSForm> getForms() throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM FORMS");
		List<TRMSForm> tmpList = new ArrayList<TRMSForm>();
		while(rs.next()) {
			tmpList.add(new TRMSForm(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)
					,rs.getString(7),rs.getString(8),rs.getTimestamp(9),rs.getString(10),rs.getString(11),rs.getFloat(12), rs.getFloat(13)
					,rs.getFloat(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),
					rs.getString(21),rs.getString(22)));
		}
		return tmpList;
	}
	
	
	public void insertForm(TRMSForm form) throws SQLException{
		Connection conn = cf.getConnection();
		System.out.println(form);
		String sql = "INSERT INTO FORMS(FORM_ID, EMP_ID, EMP_FIRSTNAME, EMP_LASTNAME, EMP_EMAIL, EMP_TYPE, FORM_EVENT_TYPE, FORM_SUBMIT_TIME,"
				+ "FORM_EVENT_TIME, FORM_LOCATION, FORM_DESCRIPTION, FORM_COST, FORM_RMBRSMNT_AMT," 
				+ "FORM_EMP_AVAIL_AMT, FORM_GRADE_FORMAT_ID, FORM_JUSTIFICATION, EMP_DEPARTMENT, EMP_BRANCH)"
				+ " VALUES(FORMID.NEXTVAL,?,?,?,?,?,?,systimestamp,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,form.getEmpID());
		ps.setString(2, form.getFirstName());
		ps.setString(3, form.getLastName());
		ps.setString(4, form.getEmail());
		ps.setString(5, form.getType());
		ps.setString(6, form.getEventType());
		ps.setTimestamp(7, form.getEventTime());
		ps.setString(8, form.getLocation());
		ps.setString(9, form.getDescription());
		ps.setFloat(10, form.getCost());
		ps.setFloat(11, form.getRmbrsmntAmt());
		ps.setFloat(12, form.getEmpAvailAmt());
		ps.setString(13, form.getGradeFormat());
		ps.setString(14, form.getJustification());
		ps.setString(15, form.getDepartment());
		ps.setString(16, form.getBranch());
		ps.executeUpdate();
	}
	
	public void updateForm(int formID,  String directSupervisorApproval,String departmentHeadApproval,String benCoApproval,String rejectionReason ) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{ CALL UPDATEFORM(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, formID);
		call.setString(2, directSupervisorApproval);
		call.setString(3, departmentHeadApproval);
		call.setString(4, benCoApproval);
		call.setString(5, rejectionReason);
		call.execute();
	}
	

	public void returnMoney(int empID, float rmbrsmntAmt) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ CALL RETURNMONEY(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, empID);
		call.setFloat(2, rmbrsmntAmt);
		call.execute();
	}
	
	
	
	public void createMessage(int formID, int empID, float oldAmtm, float newAmt, int urgent, int response,  String additionalInfo) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO MESSAGES VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,formID);
		ps.setInt(2,empID);
		ps.setFloat(3, oldAmtm);
		ps.setFloat(4, newAmt);
		ps.setInt(5,urgent);
		ps.setInt(6,response);
		ps.setString(7, additionalInfo);
		ps.executeUpdate();
	}
	
	public List<Messages> getMessages() throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM MESSAGES");
		List<Messages> tmpList = new ArrayList<Messages>();
		while(rs.next()) {
			tmpList.add(new Messages(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
		}
		return tmpList;
	}
	
}
	