package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.project.businesscomponent.model.Corsista;
import com.project.businesscomponent.model.Corso;

public class CorsoCorsistaDAO implements DAOConstants{
	private CachedRowSet rowSet;
	
	public static CorsoCorsistaDAO getFactory() throws SQLException {
		return new CorsoCorsistaDAO();
	}
	private CorsoCorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
	
	public void create(Connection conn, long codCorso,long codCorsista) throws SQLException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA_TOT);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, codCorso);
			rowSet.updateLong(2, codCorsista);
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException exc) {
			exc.printStackTrace();
		}
		}
	public void delete(Connection conn, long codcorso,long codCorsista) throws SQLException {
		try {
		PreparedStatement ps = conn.prepareStatement(DELETE_CORSO_CORSISTA);
		ps.setLong(1, codcorso);
		ps.setLong(2, codCorsista);
		ps.execute();
		conn.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	@SuppressWarnings("finally")
	public long[] getCorsoByCorsista(Connection conn,long codCorsista) throws SQLException{
		ArrayList<Long> corsi=new ArrayList<Long>();
		try {
			PreparedStatement ps=conn.prepareStatement(SELECT_CORSO_BY_CORSISTA);
			ps.setLong(1, codCorsista);
			rowSet.populate(ps.executeQuery());
			while(rowSet.next()) {
				corsi.add(rowSet.getLong(1));
			}		
		}catch(SQLException exc){
			throw exc;
			
		}finally {
			long[]codC=new long[corsi.size()];
			for(int i=0;i<corsi.size();i++)
				codC[i]=corsi.get(i);
			return codC;
		}
	
		}
	
	@SuppressWarnings("finally")
	public long[] getCorsistaByCorso(Connection conn,long codCorso) throws SQLException{
		ArrayList<Long> corsista=new ArrayList<Long>();
		try {
			PreparedStatement ps=conn.prepareStatement(SELECT_CORSISTA_BY_CORSO);
			ps.setLong(1, codCorso);
			rowSet.populate(ps.executeQuery());
			while(rowSet.next()) {
				corsista.add(rowSet.getLong(2));
			}		
		}catch(SQLException exc){
			throw exc;
			
		}finally {
			long[]codC=new long[corsista.size()];
			for(int i=0;i<corsista.size();i++)
				codC[i]=corsista.get(i);
			return codC;
		}
	}
}
