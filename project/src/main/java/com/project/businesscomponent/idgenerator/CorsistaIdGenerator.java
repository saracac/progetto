package com.project.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.architecture.dao.DAOConstants;
import com.project.architecture.dbaccess.DBAccess;

public class CorsistaIdGenerator implements DAOConstants{
	private static CorsistaIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsistaIdGenerator() throws ClassNotFoundException, IOException, SQLException {
		conn=DBAccess.getConnection();
	}
	
	public CorsistaIdGenerator getInstance() throws ClassNotFoundException, IOException, SQLException {
		if(istanza==null)
			istanza=new CorsistaIdGenerator();
		return istanza;	
	}
	
	
	public long getNextId()
			throws ClassNotFoundException, IOException, SQLException {
		long id=0;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(SELECT_CORSISTA_SEQ);
			rs.next();
			id=rs.getLong(1);		 
		}catch (SQLException sql) {
			throw sql;
		}
		return id;		
	}

}
