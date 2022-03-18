package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.project.architecture.dao.CorsoDAO;
import com.project.businesscomponent.idgenerator.CorsoIdGenerator;
import com.project.businesscomponent.model.Corso;

public class CorsoBC {
	private static Connection conn;
	private CorsoIdGenerator csGen;
	
	public CorsoBC() {}
	
	public void create(Corso corso) throws ClassNotFoundException, IOException, SQLException
	{
		corso.setCodCorso(csGen.getInstance().getNextId());
		CorsoDAO.getFactory().create(conn, corso);
	}
	
	public void delete(Corso corso) throws SQLException
	{
		CorsoDAO.getFactory().delete(conn, corso);
	}
	
	public void deleteCorsi(Corso[] corsi) throws SQLException
	{
		for (int i = 0; i < corsi.length ; i++) {
			CorsoDAO.getFactory().delete(conn, corsi[i]);
		}
	}
	
	public Corso getByPk(long codCorso) throws SQLException 
	{
		return CorsoDAO.getFactory().getByPk(conn, codCorso);
	}
	
	public Corso[] corsiDisp() throws SQLException 
	{
		Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
		return corsi;
	}
	
	public Date dataInizioUltimoCorso() throws SQLException 
	{
		return CorsoDAO.getFactory().dataInizioUltimoCorso(conn);
	}
	
	public Corso corsoPiuFreq() throws SQLException {
		return CorsoDAO.getFactory().corsoPiuFreq(conn);
	}
	
	public double durataMediaCorsi() throws SQLException {
		return CorsoDAO.getFactory().durataMediaCorsi(conn);
	}
	
	public double numeroComm() throws SQLException {
		return CorsoDAO.getFactory().numeroComm(conn);
	}
}
