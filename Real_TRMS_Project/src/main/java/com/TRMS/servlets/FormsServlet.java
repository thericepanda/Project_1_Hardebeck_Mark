package com.TRMS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TRMS.beans.TRMSForm;
import com.TRMS.dao.EmployeeDAOImpl;
import com.TRMS.dao.TRMSFormDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FormsServlet
 */
public class FormsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forms git");
		ObjectMapper mapper = new ObjectMapper();
		TRMSFormDAOImpl tdi = new TRMSFormDAOImpl();
		PrintWriter pw = response.getWriter();
		String formJSON = null;
		try {
			formJSON = mapper.writeValueAsString(tdi.getForms());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		pw.print(formJSON);
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form post");
		ObjectMapper mapper = new ObjectMapper();
		TRMSForm form = null;
		form = mapper.readValue(request.getInputStream(), TRMSForm.class);
		TRMSFormDAOImpl tdi = new TRMSFormDAOImpl();
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		Long weirdOffSet = (long) (1000*60*60*2);
		form.getEventTime().setTime(form.getEventTime().getTime() + weirdOffSet);
		if ((form.getEventTime().getTime() - System.currentTimeMillis())<604800000) {
			PrintWriter pw = response.getWriter();
			System.out.println("enter a week later");
			String res = mapper.writeValueAsString("Alert");
			pw.print(res);
			pw.flush();
		}else {
			System.out.println(form.getEmpID());
			
			try {
				
				
						if(form.getEventType().equals("Certification")) {
							
							if (form.getCost()>form.getEmpAvailAmt()) {
								edi.updateAmtAvail(form.getEmpID(), 0);
							}else {
								float x = form.getEmpAvailAmt()- form.getCost();
								edi.updateAmtAvail(form.getEmpID(), x);
								System.out.println(x);
							}
						}else if(form.getEventType().equals("Technical Training")) {
							if (.9*form.getCost()>form.getEmpAvailAmt()) {
								edi.updateAmtAvail(form.getEmpID(), 0);
							}else {
								float x = (float) (form.getEmpAvailAmt() - (form.getCost())*.9);
								edi.updateAmtAvail(form.getEmpID(), x);
							}
						}else if(form.getEventType().equals("University Courses")) {
							if (.8*form.getCost()>form.getEmpAvailAmt()) {
								edi.updateAmtAvail(form.getEmpID(), 0);
							}else {
								float x = (float) (form.getEmpAvailAmt()- (form.getCost())*.8);
								edi.updateAmtAvail(form.getEmpID(), x);
								System.out.println("im in here????");
							}
						}else if(form.getEventType().equals("Certification Preparation Classes")) {
							if (.75*form.getCost()>form.getEmpAvailAmt()) {
								edi.updateAmtAvail(form.getEmpID(), 0);
							}else {
								float x = (float) (form.getEmpAvailAmt() - (form.getCost())*.75);
								edi.updateAmtAvail(form.getEmpID(), x);
							}
						}else if(form.getEventType().equals("Seminar")) {
							if (.6*form.getCost()>form.getEmpAvailAmt()) {
								edi.updateAmtAvail(form.getEmpID(), 0);
							}else {
								float x = (float) (form.getEmpAvailAmt() - (form.getCost())*.6);
								edi.updateAmtAvail(form.getEmpID(), x);
							}
						}else if(form.getEventType().equals("Other")) {
							if (.3*form.getCost()>form.getEmpAvailAmt()) {
								edi.updateAmtAvail(form.getEmpID(), 0);
							}else {
								float x = (float) (form.getEmpAvailAmt() - (form.getCost())*.3);
								edi.updateAmtAvail(form.getEmpID(), x);
							}
						}
					
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
			try {
				System.out.println(form);
				tdi.insertForm(form);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			response.setStatus(201);
	}

}
