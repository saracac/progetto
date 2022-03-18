package com.project.architecture.dao;

public interface DAOConstants {
	
	// AMMINISTRATORE
	String SELECT_ADMIN_BYPK="Select nomeAdmin,cognomeAdmin from Amministratore where codAdmin=?"; 
	
	//DOCENTE
	
	//CORSO
	String SELECT_CORSO_SEQ="select corso_seq.nextval from dual";
	String DELETE_CORSO="Select nomecorso, datainizio, datafine, costo, commenti, aula from corso where codcorso=?";
	String SELECT_CORSO_BY_PK="Select * from corso where codcorso=?";
	String SELECT_DATA_INIZIO_CORSI="Select datainizio from corso";
	String SELECT_CORSI="Select * from corso";
	
	//CORSISTA
	String SELECT_CORSISTA_SEQ="select corsista_seq.nextval from dual";
	String SELECT_CORSISTA ="Select * from corsista";
	String SELECT_CORSISTA_BY_PK = "Select * from corsista where codCorsista = ?";
}
