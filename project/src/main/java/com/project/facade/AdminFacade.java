package com.project.facade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.project.businesscomponent.CorsistaBC;
import com.project.businesscomponent.CorsoBC;
import com.project.businesscomponent.model.Corsista;
import com.project.businesscomponent.model.Corso;

// Bisogna importare le classi bc perche nonn erano ancora state fatte al momento della creazione della facciata
public class AdminFacade {
	private static AdminFacade aF;
	
	private AdminFacade() {}
	
	public AdminFacade getInstance() {
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
	
	public Corso corsoPiuFreq() {
		CorsoBC cBC=new CorsoBC();
		return cBC.corsoPiuFreq();	
	}

	public void deleteCorsi(Corso[]corsi) {
		CorsoBC cBC=new CorsoBC();
		cBC.deleteCorsi(corsi);
	}
	
	public Date dataInizioUltimoCorso() {
		CorsoBC cBC=new CorsoBC();
		return cBC.dataInizioUltimoCorso();
	}
	
	public double durataMediaCorsi() {
		CorsoBC cBC=new CorsoBC();
		return cBC.durataMediaCorsi();
	}
	
	public int numeroComm() {
		CorsoBC cBC=new CorsoBC();
		return cBC.numeroComm();
	}
	
	public Corso[] corsiDisp() {
		CorsoBC cBC=new CorsoBC();
		return cBC.corsiDisp();
	}
	
	//DOCENTE
	
	public Docente docentePiuCorsi() {
		DocenteBC dBC= new DocenteBC();
		return dBC.docentePiuCorsi();
	}
	
}
