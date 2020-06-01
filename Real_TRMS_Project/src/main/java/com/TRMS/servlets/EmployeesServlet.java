package com.TRMS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TRMS.beans.UpdateBean;
import com.TRMS.dao.EmployeeDAOImpl;
import com.TRMS.dao.TRMSFormDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeesServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("employee get");
		ObjectMapper mapper = new ObjectMapper();
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		PrintWriter pw = response.getWriter();
		try {
			String employeesJSON = mapper.writeValueAsString(edi.getEmployeeList());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(employeesJSON);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updating the approval/denial");
		ObjectMapper mapper = new ObjectMapper();
		UpdateBean update = null;
		TRMSFormDAOImpl tdi = new TRMSFormDAOImpl();
		update = mapper.readValue(request.getInputStream(), UpdateBean.class);
		if(update.getBenCoApproval().equals("Approved")) {
			update.setDirectSupervisorApproval("Approved");
			update.setDepartmentHeadApproval("Approved");
		}
		if(update.getDepartmentHeadApproval().equals("Approved")) {
			update.setDirectSupervisorApproval("Approved");
		}
		if(update.getBenCoApproval().equals("Denied")) {
			update.setDirectSupervisorApproval("Denied");
			update.setDepartmentHeadApproval("Denied");
		}
		if(update.getDepartmentHeadApproval().equals("Denied")) {
			update.setDirectSupervisorApproval("Denied");
		}
		
		if(update.getDirectSupervisorApproval().equals("Denied")) {
			System.out.println("he");
			try {
				for (int i = 0; i < tdi.getForms().size(); i++) {
					if(tdi.getForms().get(i).getFormID() == update.getFormID()) {
						System.out.println("llo");
						tdi.returnMoney(tdi.getForms().get(i).getEmpID(), tdi.getForms().get(i).getRmbrsmntAmt());
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			tdi.updateForm(update.getFormID(),update.getDirectSupervisorApproval(), update.getDepartmentHeadApproval(), update.getBenCoApproval(), update.getRejectionReason());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}