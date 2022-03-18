package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.architecture.dao.AmministratoreDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.model.Amministratore;

public class AmministratoreBC {
	Connection conn;
	
	public AmministratoreBC() throws ClassNotFoundException, SQLException, IOException {
		conn=DBAccess.getConnection();
	}
	
	public Amministratore getByPk(long pk) throws SQLException {
		try {
			return AmministratoreDAO.getFactory().getByPk(conn, pk);
			
			
		}catch(SQLException exc) {
			throw exc;
			
		}
	}
	
}
