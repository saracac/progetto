package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.utility.LoginUtility;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codiceAdmin=request.getParameter("codAdmin");
		String nomeAdmin=request.getParameter("nomeAdmin");
		HttpSession session= request.getSession();
		
		int nTentativi;
		if(session.getAttribute("tentativo")!=null)
			nTentativi=(int) session.getAttribute("tentativo");
		else
			session.setAttribute("tentativo",1);
		if(nTentativi>5)
			response.sendRedirect("accessonegato.jsp");
		if(codiceAdmin!=null&&nomeAdmin!=null) {
			long codAdmin=Long.parseLong(request.getParameter("codAdmin"));
			try {	
				boolean accesso=LoginUtility.getFactory().accessGranted(nomeAdmin,codAdmin);
				
			}
		}
	}

}
