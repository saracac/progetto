package com.project.architecture.dao;

public interface DAOConstants {
	
	// AMMINISTRATORE
	String SELECT_ADMIN_BYPK="Select nomeAdmin,cognomeAdmin from Amministratore where codAdmin=?"; 
	
	//DOCENTE
	
	//CORSO
	
	//CORSISTA
	String SELECT_CORSISTA_SEQ="select corsista_seq.nextval from dual";
	
}
