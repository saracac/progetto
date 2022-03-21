package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.project.businesscomponent.model.Corsista;


public class CorsistaDAO implements DAOConstants {
	private CachedRowSet rowSet;
	
	
	
	public static CorsistaDAO getFactory() throws SQLException {
		return new CorsistaDAO();
	}
	
	private CorsistaDAO() throws SQLException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}
		catch(SQLException sql) {
			throw sql;
		}
	}
	public void create(Connection conn, Corsista corsista) throws SQLException {
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, corsista.getNomeCorsista());
			rowSet.updateString(2, corsista.getCognomeCorsista());
			rowSet.updateLong(3, corsista.getCodCorsista());
			rowSet.updateLong(4, corsista.getPrecedentiformativi());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException sql) {
			throw sql;
			}
	}
	
	public Corsista getByPk(Connection conn, long codCorsista) throws SQLException{
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BY_PK);
			ps.setLong(1,  codCorsista);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {//se rs true, quindi il cursore ha trovato un valore, quindi setta i nomi prendendoli con il get
				corsista = new Corsista();
				corsista.setNomeCorsista(rs.getString(1));
				corsista.setCognomeCorsista(rs.getString(2));
				corsista.setCodCorsista(rs.getLong(3));
				corsista.setPrecedentiformativi(rs.getLong(4));
			}
			
		} catch (SQLException sql) {
			throw sql;
		}
		return corsista;	
	}
	
	public Corsista[] getAll(Connection conn) throws SQLException {
		Corsista[] corsisti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			corsisti = new Corsista[rs.getRow()]; // tutti istanziati quindi tutti vuoti quindi con il vìbefore first riparto e inizio ad inserirci i valori
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setNomeCorsista(rs.getString(1));
				c.setCognomeCorsista(rs.getString(2));
				c.setCodCorsista(rs.getLong(3));
				c.setPrecedentiformativi(rs.getLong(4));
				corsisti[i] = c;  // una volta terminato il riempimento si inserisce il nuovo c dentro all'array corsisti sopra
			}
			rs.close();
		} catch (SQLException sql) {
			throw sql;
		}
		return corsisti;
	}
	

	public int corsistaTot(Connection conn) throws SQLException {
		int val = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(COUNT_CORSISTI);
			rs.next();
			val = rs.getInt(1);
		}catch(SQLException sql) {
			throw sql;
		}return val;
	}
}
