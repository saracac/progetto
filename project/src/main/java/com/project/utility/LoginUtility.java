package com.project.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.AmministratoreBC;

public class LoginUtility {
	
	public static LoginUtility getFactory(){
		return new LoginUtility(); 
	}
	
	private LoginUtility() {
	}

	public boolean accessGranted(String nomeAdmin,long codAdmin) throws SQLException, ClassNotFoundException, IOException {
		AmministratoreBC aBC=new AmministratoreBC();
		String nomeGiusto=aBC.getByPk(codAdmin).getNomeAdmin();
		if(nomeGiusto!=null&&nomeGiusto.equals(nomeAdmin))
			return true;
		else
			return false;
	}
}
