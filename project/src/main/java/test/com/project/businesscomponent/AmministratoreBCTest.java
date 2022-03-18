package test.com.project.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.architecture.dao.AmministratoreDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.model.Amministratore;

class AmministratoreBCTest {
	Connection conn;

	@BeforeEach
	void setUp() throws Exception {
		conn=DBAccess.getConnection();
	}

	@AfterEach
	void tearDown() throws Exception {
		DBAccess.closeConnection();
	}

	@Test
	void testGetByPk() {
		try {
			
			//Test non ancora effettuato il codAdmin dovra essere cambiato una volta inseriti dei dati di prova nel db
			long codAdmin=2L;
			Amministratore admin=new Amministratore();
			admin=AmministratoreDAO.getFactory().getByPk(conn, codAdmin);
			System.out.println(admin.toString());
			
		}catch(SQLException exc) {
			exc.printStackTrace();
			System.out.println(exc.getMessage());
			System.out.println(exc.getCause());
			System.out.println(exc.getErrorCode());
			fail();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			System.out.println(exc.getMessage());
			fail();
		}
	}

}
