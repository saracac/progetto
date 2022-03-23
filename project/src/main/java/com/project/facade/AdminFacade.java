package com.project.facade;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.project.businesscomponent.CorsistaBC;
import com.project.businesscomponent.CorsoBC;
import com.project.businesscomponent.CorsoCorsistaBC;
import com.project.businesscomponent.DocenteBC;
import com.project.businesscomponent.model.Corsista;
import com.project.businesscomponent.model.Corso;
import com.project.businesscomponent.model.Docente;

// Bisogna importare le classi bc perche nonn erano ancora state fatte al momento della creazione della facciata
public class AdminFacade {
	private static AdminFacade aF;
	
	private AdminFacade() {}
	
	public static AdminFacade getInstance() {
		if (aF==null) 
			aF=new AdminFacade();
		return aF;	
	}

	//CORSISTA
	
	public int corsistaTot() throws ClassNotFoundException, IOException, SQLException {
		CorsistaBC cBC=new CorsistaBC();
		return cBC.corsistaTot();
	}
	
	public void createCorsista(Corsista corsista) throws ClassNotFoundException, IOException, SQLException {
		CorsistaBC cBC=new CorsistaBC();
		cBC.create(corsista);		
	}
	
	public Corsista[] elencoCorsisti() throws SQLException, ClassNotFoundException, IOException {
 
		CorsistaBC cBC=new CorsistaBC();
		return cBC.getAll();	
	}
	
	//CORSO
	public void createCorso(Corso corso) throws ClassNotFoundException, IOException, SQLException {
		CorsoBC corsoBC = new CorsoBC();
		corsoBC.create(corso);
	}
	
	public Corso corsoPiuFreq() throws SQLException, ClassNotFoundException, IOException {
		CorsoBC cBC=new CorsoBC();
		return cBC.corsoPiuFreq();	// DA FARE
	}

	public void deleteCorsi(ArrayList<Long> corsi) throws SQLException, ClassNotFoundException, IOException {
		CorsoBC cBC=new CorsoBC();
		cBC.deleteCorsi(corsi);
	}
	
	public Date dataInizioUltimoCorso() throws SQLException, ClassNotFoundException, IOException {
		CorsoBC cBC=new CorsoBC();
		return cBC.dataInizioUltimoCorso();
	}
	
	public double durataMediaCorsi() throws SQLException, ClassNotFoundException, IOException {
		CorsoBC cBC=new CorsoBC();
		return cBC.durataMediaCorsi();
	}
	
	public int numeroComm() throws SQLException, ClassNotFoundException, IOException {
		CorsoBC cBC=new CorsoBC();
		return cBC.numeroComm(); // DA FARE
	}
	
	public Corso[] corsiDisp() throws SQLException, ClassNotFoundException, IOException, ParseException {
		CorsoBC cBC=new CorsoBC();
		return cBC.corsiDisp(); 
	}
	
	// CORSO CORSISTA
	public Corso[] getCorsiCorsista(long codCorsista) throws SQLException, ClassNotFoundException, IOException {
		CorsoBC cBC = new CorsoBC();
		return cBC.listaCorsiCorsista(codCorsista); 
	}
	public void createCorsoCorsista(long codCorsista, long codCorso) throws ClassNotFoundException, IOException, SQLException {
		CorsoCorsistaBC ccBc = new CorsoCorsistaBC();
		ccBc.create(codCorso, codCorsista); 
	}
	public long[] getCorsoByCorsista(long codCorsista) throws SQLException, ClassNotFoundException, IOException {
		CorsoCorsistaBC ccBc = new CorsoCorsistaBC();
		return ccBc.getCorsoByCorsista(codCorsista);
	}
	
	//DOCENTE
	
	public Docente docentePiuCorsi() throws SQLException, ClassNotFoundException, IOException {
		DocenteBC dBC= new DocenteBC();
		return dBC.docentePiuCorsi(); // DA FARE
	}
}
