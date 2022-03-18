package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.architecture.dao.CorsistaDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.project.businesscomponent.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
		
	}
	
	public Corsista[] getAll() throws SQLException {
	 try {
		 return CorsistaDAO.getFactory().getAll(conn);
		 
	 }catch(SQLException sql) {
		 throw sql;
	 }
		
	}
	
	public void create(Corsista corsista) throws ClassNotFoundException, IOException, SQLException {
		try {
			corsista.setCodCorsista((CorsistaIdGenerator.getInstance().getNextId()));
			CorsistaDAO.getFactory().create(conn, corsista);
			
		}catch(SQLException sql) {
			throw sql;
		}
	}
	
	public Corsista getById(long codCorsista) throws SQLException {
		try {
		return CorsistaDAO.getFactory().getByPk(conn, codCorsista);
		
	}catch(SQLException sql) {
		throw sql;
	}
}
	
	public int corsistaTot() {
		
		return 0;
	}
}
