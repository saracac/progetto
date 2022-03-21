package com.project.utility;

import java.io.IOException;
import java.sql.SQLException;

import com.project.businesscomponent.AmministratoreBC;

public class LoginUtility {
	
	public static LoginUtility getFactory(){
		return new LoginUtility(); 
	}
	
	private LoginUtility() {
	}

	public boolean accessGranted(String nomeAdmin,long codAdmin) throws SQLException, ClassNotFoundException, IOException{
		try{
			AmministratoreBC aBC=new AmministratoreBC();
			
		String nomeGiusto=aBC.getByPk(codAdmin).getNomeAdmin();
		
		if(nomeGiusto!=null&&nomeGiusto.equals(nomeAdmin))
			return true;
		else
			return false;
		}catch(NullPointerException e) {
			return false;	
		}
	}
}
