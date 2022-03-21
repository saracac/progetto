package com.project.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.architecture.dao.DAOConstants;
import com.project.architecture.dbaccess.DBAccess;

public class DocenteIdGenerator implements IdGeneratorInterface, DAOConstants{
	private static DocenteIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private DocenteIdGenerator() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}
	
	public static DocenteIdGenerator getInstance() throws ClassNotFoundException, IOException, SQLException {
		if(istanza == null)
			istanza = new DocenteIdGenerator();
		return istanza;	
	}
	
	@Override
	public long getNextId()
			throws ClassNotFoundException, IOException, SQLException {
		long id=0;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("SELECT_DOCENTE_SEQ"); // da inserire
			rs.next();
			id=rs.getLong(1);		 
		}catch (SQLException sql) {
			throw sql;
		}
		return id;		
	}

}