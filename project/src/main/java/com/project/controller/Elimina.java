package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.businesscomponent.model.Corso;
import com.project.facade.AdminFacade;

//@WebServlet("/Elimina")
public class Elimina extends HttpServlet {
	private static final long serialVersionUID = 6739802845016161106L;
	private static AdminFacade aF = AdminFacade.getInstance();
	private Corso[] corsi;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException { // Quando premo il pulsante "Elimina corsi"
		HttpSession session = request.getSession();
		try {
			corsi = aF.corsiDisp(); // Ottengo i corsi disponibili
			session.setAttribute("corsi", corsi); // Imposto corsi come parametro di sessione
			response.sendRedirect(request.getContextPath() + "/elimina.jsp"); // Reindirizzo alla Jsp
		} catch (SQLException e) { // Se non voglio gestirla qui devo rilanciarla direttamente (throw)
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] values = request.getParameterValues("corso");
        ArrayList<Long> corsiDaEliminare = new ArrayList<Long>(); // Uso un arraylist perchè non so quanti corsi sono checked
        for (String val : values)
        	if (val.equals("on")) // se il checkbox è checked
        	{
        		corsiDaEliminare.add(Long.parseLong(val)); // Inserisce i codCorso in una lista
        	}
        try {
			aF.deleteCorsi(corsiDaEliminare.toArray(new Long[0])); // Passa la lista alla facciata per l'eliminazione
		} catch (SQLException e) { // Se non voglio gestirla qui devo rilanciarla direttamente (throw)
			e.printStackTrace();
		} 
	}
}