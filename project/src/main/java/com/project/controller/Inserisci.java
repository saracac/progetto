package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.project.businesscomponent.model.Corsista;
import com.project.facade.AdminFacade;

//@WebServlet("/Inserisci")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista corsista = new Corsista();
		corsista.setNomeCorsista(request.getParameter("nome"));
		corsista.setCognomeCorsista(request.getParameter("cognome"));
		corsista.setPrecedentiformativi(1);
	try {
		AdminFacade.getInstance().createCorsista(corsista);
		response.sendRedirect(request.getContextPath() + "/visualizzastatistiche.jsp");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}

