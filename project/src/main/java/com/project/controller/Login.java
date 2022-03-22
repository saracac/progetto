package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.utility.LoginUtility;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codiceAdmin=request.getParameter("codAdmin");
		String nomeAdmin=request.getParameter("nomeAdmin");
		HttpSession session= request.getSession();
		
		int nTentativi=1;
		if(session.getAttribute("tentativo")!=null)
			nTentativi=(int) session.getAttribute("tentativo");
		else
			session.setAttribute("tentativo",1);
		
		if(nTentativi>5)
			response.sendRedirect("accessonegato.jsp");
		else if(codiceAdmin!=null&&nomeAdmin!=null&&!codiceAdmin.equals("")) {
			long codAdmin=Long.parseLong(request.getParameter("codAdmin"));
			System.out.println(nTentativi);
			try {
				if(LoginUtility.getFactory().accessGranted(nomeAdmin,codAdmin)) {
					session.setAttribute("nomeAdmin", nomeAdmin);	
					response.sendRedirect("home.jsp");
				}else {
					nTentativi++;
					session.setAttribute("tentativo", nTentativi);
					response.sendRedirect("login.jsp");}
			}catch(ClassNotFoundException exc) {
				System.err.println("ClassNotFoundException");;
			}catch(SQLException sql) {
				System.err.println("SQLException");
			}
		}
		else {
		nTentativi++;
		session.setAttribute("tentativo", nTentativi);
		response.sendRedirect("login.jsp");
		}
	}

}
