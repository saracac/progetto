package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.businesscomponent.model.Corsista;
import com.project.facade.AdminFacade;
import com.project.utility.InserisciUtility;

//@WebServlet("/Inserisci")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Corsista corsista = new Corsista();
		String nome = request.getParameter("nome");
		corsista.setNomeCorsista(nome);
		String cognome = request.getParameter("cognome");
		corsista.setCognomeCorsista(cognome);
		corsista.setPrecedentiformativi(1);
		try {
			InserisciUtility.getFactory();
			if (InserisciUtility.isValidName(nome) && InserisciUtility.isValidSurname(cognome)) {
				AdminFacade.getInstance().createCorsista(corsista);
				response.sendRedirect(request.getContextPath() + "/visualizzastatistiche.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/inserisci.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
