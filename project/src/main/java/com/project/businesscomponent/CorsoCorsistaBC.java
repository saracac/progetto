package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.architecture.dao.CorsoCorsistaDAO;
import com.project.architecture.dbaccess.DBAccess;

public class CorsoCorsistaBC {
	private static Connection conn;
	
	public CorsoCorsistaBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}
	
	public void delete(long codcorso,long codCorsista) throws SQLException {
		CorsoCorsistaDAO.getFactory().delete(conn, codcorso, codCorsista);
	}
	public void create(long codcorso,long codCorsista) throws SQLException {
		CorsoCorsistaDAO.getFactory().create(conn, codcorso, codCorsista);
	}
	public long[] getCorsoByCorsista(long codCorsista) throws SQLException{
		return CorsoCorsistaDAO.getFactory().getCorsoByCorsista(conn, codCorsista);
	}
	public long[] getCorsistaByCorso(long codCorso) throws SQLException{
		return CorsoCorsistaDAO.getFactory().getCorsistaByCorso(conn, codCorso);
	}
	
}
