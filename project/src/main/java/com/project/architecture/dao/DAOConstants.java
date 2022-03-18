package com.project.architecture.dao;

public interface DAOConstants {
	
	// AMMINISTRATORE
	String SELECT_ADMIN_BYPK="Select nomeAdmin,cognomeAdmin from Amministratore where codAdmin=?"; 
	
	//DOCENTE
	
	//CORSO
	
	//CORSISTA
	String SELECT_CORSISTA_SEQ="select corsista_seq.nextval from dual";
	String SELECT_CORSISTA ="Select * from corsista";
	String SELECT_CORSISTA_BY_PK = "Select * from corsista where codCorsista = ?";
}
