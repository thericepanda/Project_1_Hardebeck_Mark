package com.TRMS.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.TRMS.beans.Employees;
import com.TRMS.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	
	public List<Employees> getEmployeeList() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
		List<Employees> tmplist = new ArrayList<Employees>();
		while (rs.next()){
			tmplist.add(new Employees(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getFloat(8),rs.getString(9),rs.getString(10)));
		}
		return tmplist;
	}



	public void updateAmtAvail(int empID, float amtAvail) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATEAMTAVAIL(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, empID);
		call.setFloat(2, amtAvail);
		call.execute();
	}

}
