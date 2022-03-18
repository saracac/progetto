package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.project.businesscomponent.model.Corso;

public class CorsoDAO implements DAOConstants{
	private CachedRowSet rowSet;
	
	private CorsoDAO() throws SQLException {
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		rowSet = rowSetFactory.createCachedRowSet();
	}
	
	public static CorsoDAO getFactory() throws SQLException {
		return new CorsoDAO();
	}

	public void create(Connection conn, Corso corso) throws SQLException {
		rowSet.moveToInsertRow();
		rowSet.setLong(1, corso.getCodCorso());
		rowSet.setString(2, corso.getNomeCorso());
		rowSet.setDate(3, new java.sql.Date(corso.getDataInizio().getTime()));
		rowSet.setDate(4, new java.sql.Date(corso.getDataFine().getTime()));
		rowSet.setDouble(5, corso.getCosto());
		rowSet.setString(6, corso.getCommenti());
		rowSet.setShort(7, corso.getAula());
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges(conn);
	}
	
	public void delete(Connection conn, Corso corso) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_CORSO);
		ps.setLong(1, corso.getCodCorso());
		ps.execute();
		conn.commit();
	}
	
	public Corso getByPk(Connection conn, long codCorso) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSO_BY_PK);
		
		ps.setLong(1, codCorso);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
		Corso c = new Corso();
		c.setCodCorso(rs.getLong(1));
		c.setNomeCorso(rs.getString(2));
		c.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
		c.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
		c.setCosto(rs.getDouble(5));
		c.setCommenti(rs.getString(6));
		c.setAula(rs.getShort(7));
		return c;
		}
		
		return null;
	}
	
	public Date dataInizioUltimoCorso(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement( 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY); 
		
		ResultSet rs = stmt.executeQuery(SELECT_DATA_INIZIO_CORSI);
		Date last = null;
		if (rs.last()) 
		{
			last = new java.util.Date(rs.getDate(1).getTime());
		}
		return last;
	}
	
	public Corso[] getAll(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement( 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY); 
		
		ResultSet rs = stmt.executeQuery(SELECT_CORSI);
		
		rs.last();
		int dim = rs.getRow();
		Corso[] corsi = new Corso[dim];
		
		rs.beforeFirst();
		
		for(int i = 0; rs.next() ; i++) {
		Corso c = new Corso();
		c.setCodCorso(rs.getLong(1));
		c.setNomeCorso(rs.getString(2));
		c.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
		c.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
		c.setCosto(rs.getDouble(5));
		c.setCommenti(rs.getString(6));
		c.setAula(rs.getShort(7));
		corsi[i] = c;
		}
		return corsi;
	}
	
	public Corso corsoPiuFreq(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement( 
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			
		ResultSet rs = stmt.executeQuery(SELECT_CORSO_PIUFREQ);
		
		Corso c = null;
		if (rs.next()) {
			c = new Corso();
			c.setCodCorso(rs.getLong(1));
			c.setNomeCorso(rs.getString(2));
			c.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
			c.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
			c.setCosto(rs.getDouble(5));
			c.setCommenti(rs.getString(6));
			c.setAula(rs.getShort(7));
			return c;
		}
		return null;
	}
	
	public double durataMediaCorsi(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement( 
				ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_DURATA_MEDIA_CORSI);
	
		return rs.getDouble(1);
	}
	
	public int numeroComm(Connection conn) throws SQLException 
	{
		Statement stmt = conn.createStatement( 
				ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_NUMERO_COMMENTI);
		
		return rs.getInt(1);
	}
}
