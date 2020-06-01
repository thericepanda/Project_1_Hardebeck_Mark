package com.TRMS.dao;

import java.sql.SQLException;
import java.util.List;

import com.TRMS.beans.Employees;

public interface EmployeeDAO {

	//EMPLOYEE STUFF
	//Change amount available
	public void updateAmtAvail(int empID, float amtAvail) throws SQLException;
	
	//READ employee stuff
	public List<Employees> getEmployeeList() throws SQLException;
}
