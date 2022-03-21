package com.project.utility;

import java.sql.SQLException;

import com.project.businesscomponent.CorsistaBC;
import com.project.businesscomponent.model.Corsista;

public class InserisciUtility {
	
	public static InserisciUtility getFactory() {
		return new InserisciUtility();
	}
	
	public InserisciUtility() {
		
	}
	
	public boolean datiCorretti() throws SQLException {
		try {
			CorsistaBC cBC = new CorsistaBC();
			Corsista[] nuovo = CorsistaBC.getAll().getNome
		}
			
	}
	
	

}
