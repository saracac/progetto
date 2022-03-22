package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.architecture.dao.DocenteDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.idgenerator.DocenteIdGenerator;
import com.project.businesscomponent.model.Docente;

public class DocenteBC {
	private Connection conn;

	public DocenteBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();

	}

	public Docente[] getAll() throws SQLException {
		try {
			return DocenteDAO.getFactory().getAll(conn);

		} catch (SQLException sql) {
			throw sql;
		}

	}

	public void create(Docente docente) throws ClassNotFoundException, IOException, SQLException {
		try {
			docente.setcodDocente((DocenteIdGenerator.getInstance().getNextId()));
			DocenteDAO.getFactory().create(conn, docente);

		} catch (SQLException sql) {
			throw sql;
		}
	}

	public Docente getById(long codDocente) throws SQLException {
		try {
			return DocenteDAO.getFactory().getByPk(conn, codDocente);

		} catch (SQLException sql) {
			throw sql;
		}
	}

	public int DocenteTot() throws SQLException {
		try {
			return DocenteDAO.getFactory().docenteTot(conn);
		} catch (SQLException sql) {
			throw sql;
		}
	}
	
	public Docente docentePiuCorsi() throws SQLException {
		try {
			return DocenteDAO.getFactory().docentePiuCorsi(conn);
		} catch (SQLException sql) {
			throw sql;
		}
	}
}
