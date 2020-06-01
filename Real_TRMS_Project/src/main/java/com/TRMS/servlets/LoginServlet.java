package com.TRMS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.TRMS.beans.Employees;
import com.TRMS.beans.login;
import com.TRMS.dao.EmployeeDAOImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login post");
		ObjectMapper mapper = new ObjectMapper();
		login log = null;
		log = mapper.readValue(request.getInputStream(), login.class);
		System.out.println(log);
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		try {
			for(int i = 0; i<edi.getEmployeeList().size();i++) {
				if(log.getUsername().equals(edi.getEmployeeList().get(i).getUsername())){
					if(log.getPassword().equals(edi.getEmployeeList().get(i).getPassword())) {
						System.out.println("Welcome, "+ log.getUsername());
							PrintWriter pw = response.getWriter();
							response.setContentType("application/json");
							response.setCharacterEncoding("UTF-8");
							System.out.println("successful login");
							String emp = mapper.writeValueAsString(edi.getEmployeeList().get(i));
							pw.print(emp);
							pw.flush();
					}else {
						PrintWriter pw = response.getWriter();
						System.out.println("unsuccessful login");
						Employees e  = new Employees();
						e.setEmpID(0);
						e.setAmtAvail(1);
						e.setBranch("ab");
						e.setDepartment("ab");
						e.setEmail("ab");
						e.setFirstName("ab");
						e.setLastName("ab");
						e.setPassword("ab");
						e.setType("ab");
						e.setUsername("ab");
						String emp = mapper.writeValueAsString(e);
						pw.print(emp);
						pw.flush();
					}
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
