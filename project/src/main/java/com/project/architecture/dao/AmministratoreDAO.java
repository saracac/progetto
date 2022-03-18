package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.project.businesscomponent.model.Amministratore;

public class AmministratoreDAO implements DAOConstants{
	private CachedRowSet rowSet;
	
	// Costante da eliminare thx Sara
	String SELECT_ADMIN_BYPK="Select nomeAdmin,cognomeAdmin from Amministratore where codAdmin=?";
	
	public static AmministratoreDAO getFactory() {
		return new AmministratoreDAO();
	}
	private AmministratoreDAO() {
		
	}
	
	public Amministratore getByPk(Connection conn,long codAdmin) throws SQLException{
		Amministratore admin=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SELECT_ADMIN_BYPK);
			ps.setLong(1, codAdmin);
			rowSet.populate(ps.executeQuery());
			if(rowSet.next()) {
				admin=new Amministratore();
				admin.setNomeAdmin(rowSet.getString(1));
				admin.setCognomeAdmin(rowSet.getString(2));
				admin.setCodAdmin(codAdmin);	
			}		
		}catch(SQLException exc){
			throw exc;
			
		}finally {
			return admin;
		}
	
		}
}
