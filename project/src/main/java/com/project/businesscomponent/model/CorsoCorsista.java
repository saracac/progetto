package com.project.businesscomponent.model;

public class CorsoCorsista {
	private long codCorso;
	private long codCorsista;
	public long getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}
	public long getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}
	@Override
	public String toString() {
		return "CorsoCorsista [codCorso=" + codCorso + ", codCorsista=" + codCorsista + "]";
	}
	
}
