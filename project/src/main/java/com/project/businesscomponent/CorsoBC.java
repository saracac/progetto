package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.project.architecture.dao.CorsoDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.idgenerator.CorsoIdGenerator;
import com.project.businesscomponent.model.Corso;

public class CorsoBC {
	private static Connection conn;
	
	public CorsoBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corso corso) throws ClassNotFoundException, IOException, SQLException
	{
		corso.setCodCorso(CorsoIdGenerator.getInstance().getNextId());
		CorsoDAO.getFactory().create(conn, corso);
	}
	
	public void delete(long codCorso) throws SQLException
	{
		CorsoDAO.getFactory().delete(conn, codCorso);
	}
	
	public void deleteCorsi(ArrayList<Long> corsi) throws SQLException
	{
		for (int i = 0; i < corsi.size() ; i++) {
			CorsoDAO.getFactory().delete(conn, corsi.get(i));
		}
	}
	
	public Corso getByPk(long codCorso) throws SQLException 
	{
		return CorsoDAO.getFactory().getByPk(conn, codCorso);
	}
	
	public Corso[] corsiDisp() throws SQLException, ParseException 
	{
		Corso[] corsi = CorsoDAO.getFactory().getCorsiDisponibili(conn);
		return corsi;
	}
	
	public String dataInizioUltimoCorso() throws SQLException 
	{
		return CorsoDAO.getFactory().dataInizioUltimoCorso(conn);
	}
	
	public Corso corsoPiuFreq() throws SQLException {
		return CorsoDAO.getFactory().corsoPiuFreq(conn);
	}
	
	public double durataMediaCorsi() throws SQLException {
		return CorsoDAO.getFactory().durataMediaCorsi(conn);
	}
	
	public int numeroComm() throws SQLException {
		return CorsoDAO.getFactory().numeroComm(conn);
	}
	
	public Corso[] listaCorsiCorsista(long codCorsista) throws SQLException {
		return CorsoDAO.getFactory().getCorsiCorsista(conn, codCorsista);
	}
}
