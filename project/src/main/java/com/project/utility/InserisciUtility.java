package com.project.utility;


import com.project.businesscomponent.model.Corsista;

public class InserisciUtility {
	
	public static InserisciUtility getFactory() {
		return new InserisciUtility();
	}
	
	public InserisciUtility() {
		
	}
	
	public boolean datiCorretti(String nome, String cognome) {
		try {
		Corsista corsista = new Corsista();
		if(corsista.getNomeCorsista() != null && corsista.getNomeCorsista().isEmpty()) {
			return true;
		}else if(corsista.getNomeCorsista().length()<=30 && corsista.getCognomeCorsista().length()<=30) {
			return true;
			
		}else
			return false;
	
		}catch(Exception e) {
			return false;
		}
			
	}
	public static boolean isValid(String nome, String cognome) {
		String regex = 
	}
	

}
