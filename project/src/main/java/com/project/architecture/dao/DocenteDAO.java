package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.project.businesscomponent.model.Docente;

public class DocenteDAO implements DAOConstants {
	private CachedRowSet rowSet;

	public static DocenteDAO getFactory() throws SQLException {
		return new DocenteDAO();
	}

	private DocenteDAO() throws SQLException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw sql;
		}
	}

	public void create(Connection conn, Docente docente) throws SQLException {
		try {
			rowSet.setCommand(SELECT_DOCENTE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, docente.getNomeDocente());
			rowSet.updateString(2, docente.getCognomeDocente());
			rowSet.updateLong(3, docente.getCvDocente());
			rowSet.updateLong(4, docente.getCodDocente());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw sql;
		}
	}

	public Docente getByPk(Connection conn, long codDocente) throws SQLException {
		Docente docente = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BY_PK);
			ps.setLong(1, codDocente);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				docente = new Docente();
				docente.setNomeDocente(rs.getString(1));
				docente.setCognomeDocente(rs.getString(2));
				docente.setCvDocente(rs.getLong(3));
				docente.setcodDocente(rs.getLong(4));
			}

		} catch (SQLException sql) {
			throw sql;
		}
		return docente;
	}

	public Docente[] getAll(Connection conn) throws SQLException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE);
			rs.last();
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente d = new Docente();
				d.setNomeDocente(rs.getString(1));
				d.setCognomeDocente(rs.getString(2));
				d.setCvDocente(rs.getLong(3));
				d.setcodDocente(rs.getLong(4));
				docenti[i] = d;
			}
			rs.close();
		} catch (SQLException sql) {
			throw sql;
		}
		return docenti;
	}

	String COUNT_DOCENTI = "Select count(codDocente) from docenti";

	public int docenteTot(Connection conn) throws SQLException {
		int val = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(COUNT_DOCENTI);
			rs.next();
			val = rs.getInt(1);
		} catch (SQLException sql) {
			throw sql;
		}
		return val;
	}
	
	public Docente docentePiuCorsi(Connection conn) { // TODO
		return new Docente();
	}
}
