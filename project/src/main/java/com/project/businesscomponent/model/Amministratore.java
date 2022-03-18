package com.project.businesscomponent.model;

public class Amministratore {
	private String nomeAdmin;
	private String cognomeAdmin;
	private long codAdmin;
	
	public Amministratore() {
	}

	public String getNomeAdmin() {
		return nomeAdmin;
	}

	public String getCognomeAdmin() {
		return cognomeAdmin;
	}

	public long getCodAdmin() {
		return codAdmin;
	}
	
	// Ci siamo sbagliati per cio che riguarda i setters,servono nel dao per poter restituire gli oggetti istanziati :)
	
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}

	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}
	
	public void setCodAdmin(long codAdmin) {
		this.codAdmin = codAdmin;
	}

	@Override
	public String toString() {
		return "Amministratore [nome=" + nomeAdmin + ", cognome=" + cognomeAdmin + ", codice=" + codAdmin+ "]";
	}
	

}
