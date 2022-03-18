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
	
	public void create(Corso corso)
	{
		try {
		corso.setCodCorso(csGen.getInstance().getNextId());
		CorsoDAO.getFactory().create(conn, corso);
		}
		catch (SQLException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			System.out.println("Errore nella creazione del corso");
		}	
	}
	
	public void delete(Corso corso) // DELETE CORSO
	{
		try {
			CorsoDAO.getFactory().delete(conn, corso);
			}
			catch (SQLException exc) {
				exc.printStackTrace();
				System.out.println("Errore nella cancellazione del corso");
			}
	}
	
	public void deleteCorsi(Corso[] corsi) // DELETE CORSI
	{
		for (int i = 0; i < corsi.length ; i++) {
			try {
				CorsoDAO.getFactory().delete(conn, corsi[i]);
				}
				catch (SQLException exc) {
					exc.printStackTrace();
					System.out.println("Errore nella cancellazione del corso: " + corsi[i]);
				}
			}
	}
	
	public Corso getByPk(long codCorso) 
	{
		Corso corso = null;
		try {
			corso = CorsoDAO.getFactory().getByPk(conn, codCorso);
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		return corso;
	}
	
	public Corso[] corsiDisp() 
	{
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		return corsi;
	}
	
	public Date dataInizioUltimoCorso() 
	{
		Date data = null;
		try {
			data = CorsoDAO.getFactory().dataInizioUltimoCorso(conn);
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		return data;
	}
	
	public Corso corsoPiuFreq() {
		Corso corso = null;
		try {
			corso = CorsoDAO.getFactory().corsoPiuFreq(conn);
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		return corso;
	}
	
	public double durataMediaCorsi() {
		return 0.00;
	}
	
	public int numeroComm() {
		return 0;
	}
}
