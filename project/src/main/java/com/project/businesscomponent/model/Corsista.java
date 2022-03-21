package com.project.businesscomponent.model;

public class Corsista {
	String nomeCorsista;
	String cognomeCorsista;
	long codCorsista;
	long precedentiformativi;
	
	public String getNomeCorsista() {
		return nomeCorsista;
	}
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	public long getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}
	public long getPrecedentiformativi() {
		return precedentiformativi;
	}
	public void setPrecedentiformativi(long precedentiformativi) {
		this.precedentiformativi = precedentiformativi;
	}
	@Override
	public String toString() {
		return "Corsista [nomeCorsista=" + nomeCorsista + ", cognomeCorsista=" + cognomeCorsista + ", codCorsista="
				+ codCorsista + ", precedentiformativi=" + precedentiformativi + "]";
	}
	
	
	
	
	
}
