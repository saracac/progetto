package com.project.architecture.dao;

public interface DAOConstants {
	
	// AMMINISTRATORE
	String SELECT_ADMIN_BYPK="Select nomeAdmin,cognomeAdmin from Amministratore where codAdmin=?"; 
	
	//DOCENTE
	String SELECT_DOCENTE_SEQ="select docente_seq.nextval from dual";
	String SELECT_DOCENTE ="Select * from docente";
	String SELECT_DOCENTE_BY_PK = "Select * from docente where codDocente = ?";
	
	//CORSO
	String SELECT_CORSO_SEQ="select corso_seq.nextval from dual";
	String SELECT_CORSO_BY_PK="Select * from corso where codcorso=?";
	String SELECT_DATA_INIZIO_CORSI="Select datainiziocorso from corso";
	String SELECT_CORSI="Select * from corso";
	String SELECT_CORSI_DISPONIBILI="Select * from corso where datainiziocorso >= TO_DATE('2022-02-11', 'YYYY-MM-DD')";
	String SELECT_CORSO_PIUFREQ="";
	String SELECT_DURATA_MEDIA_CORSI="Select avg(datafinecorso - datainiziocorso) from corso group by codcorso";
	String SELECT_NUMERO_COMMENTI="";
	String DELETE_CORSO="Delete from corso where codcorso=?";
	
	//CORSISTA
	String SELECT_CORSISTA_SEQ="select corsista_seq.nextval from dual";
	String SELECT_CORSISTA ="Select * from corsista";
	String SELECT_CORSISTA_BY_PK = "Select * from corsista where codCorsista = ?";
	String COUNT_CORSISTI = "Select count(codCorsista) from corsista";
	
	//CORSI CORSISTA
	String SELECT_CORSO_CORSISTA="Select codcorso from corsocorsista where codcorsista = ?";
}
