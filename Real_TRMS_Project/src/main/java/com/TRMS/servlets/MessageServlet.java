package com.TRMS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TRMS.beans.Messages;
import com.TRMS.dao.TRMSFormDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public MessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("messages got");
		ObjectMapper mapper = new ObjectMapper();
		TRMSFormDAOImpl tdi = new TRMSFormDAOImpl();
		PrintWriter pw = response.getWriter();
		String formJSON = null;
		try {
			formJSON = mapper.writeValueAsString(tdi.getMessages());
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("messages post");
		ObjectMapper mapper = new ObjectMapper();
		Messages message = null;
		message = mapper.readValue(request.getInputStream(), Messages.class);
		TRMSFormDAOImpl tdi = new TRMSFormDAOImpl();
		try {
			tdi.createMessage(message.getFormID(), message.getEmpID(), message.getOldAmt(), message.getNewAmt(), message.getUrgent(), message.getResponse(), message.getAdditionalInfo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(message.getNewAmt()<message.getOldAmt()) {
			float x = message.getOldAmt() - message.getNewAmt();
			try {
				tdi.returnMoney(message.getEmpID(), x);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
