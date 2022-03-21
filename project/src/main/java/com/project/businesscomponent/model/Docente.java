package com.project.businesscomponent.model;

public class Docente {
	String nomeDocente;
	String cognomeDocente;
	long cvDocente;
	long codDocente;

	public String getNomeCorsista() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public String getCognomeDocente() {
		return cognomeDocente;
	}

	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}

	public long getCvDocente() {
		return codDocente;
	}

	public void setCvDocente(long cvDocente) {
		this.cvDocente = cvDocente;
	}

	public long getCodDocente() {
		return codDocente;
	}

	public void setcodDocente(long codDocente) {
		this.codDocente = codDocente;
	}

	@Override
	public String toString() {
		return "Docente [nomeDocente=" + nomeDocente + ", cognomeDocente=" + cognomeDocente + ", cvDocente=" + cvDocente
				+ ", codDocente=" + codDocente + "]";
	}

}
