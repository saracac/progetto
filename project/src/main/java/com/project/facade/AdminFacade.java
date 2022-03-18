package com.project.facade;

import java.util.Date;

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
	
	public int corsistaTot() {
		CorsistaBC cBC=new CorsistaBC();
		return cBC.corsistaTot();
	}
	
	public void createCorsista(Corsista corsista) {
		CorsistaBC cBC=new CorsistaBC();
		cBC.create(corsista);		
	}
	
	public Corsista[] elencoCorsisti() {
		CorsistaBC cBC=new CorsistaBC();
		return cBC.getAll();	
	}
	
	//CORSO
	
	public Corso corsoPiuFreq() {
		CorsoBC cBC=new CorsoBC();
		return cBC.corsoBC();	
	}

	public void deleteCorsi(Corso[]corsi) {
		CorsoBC cBC=new CorsoBC();
		cBC.deleteCorsi(corsi);
	}
	
	public Date dataInizioUltimoCorso() {
		CorsoBC cBC=new CorsoBC();
		cBC.dataInizioUltimoCorso();
	}
	
	public double durataMediaCorsi() {
		CorsoBC cBC=new CorsoBC();
		return cBC.durataMediaCorsi();
	}
	
	public int numeroComm() {
		CorsoBC cBC=new CorsoBC();
		return cBC.numeroComm();
	}
	
	public Corsi[] corsiDisp() {
		CorsoBC cBC=new CorsoBC();
		return cBC.corsiDisp();
	}
	
	//DOCENTE
	
	public Docente docentePiuCorsi() {
		DocenteBC dBC= new DocenteBC();
		return dBC.docentePiuCorsi();
	}
	
}
