package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.businesscomponent.CorsistaBC;
import com.project.businesscomponent.model.Corsista;

//@WebServlet("/Inserisci")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Inserisci() {
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista corsista = new Corsista();
		corsista.setNomeCorsista(request.getParameter("nome"));
		corsista.setCognomeCorsista(request.getParameter("Cognome")); 
	try {
		corsista.setCodCorsista(Long.parseLong(request.getParameter("codCorsista")));
		CorsistaBC cBC = new CorsistaBC();
		cBC.create(corsista);
		response.sendRedirect("report.jsp");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}

