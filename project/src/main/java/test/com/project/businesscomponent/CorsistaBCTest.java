package test.com.project.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.project.architecture.dao.CorsistaDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.model.Corsista;

class CorsistaBCTest {
	private static Connection conn;
	private static Corsista corsista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista.setNomeCorsista("Lucia");
		corsista.setCognomeCorsista("Rossi");
		corsista.setCodCorsista(1);
		corsista.setPrecedentiformativi(2);
		
	}

	@Test
	void createTest() {
		try {
		CorsistaDAO.getFactory().create(conn, corsista);
		System.out.println("Creato corsista");
	}catch (SQLException sql) {
		sql.printStackTrace();
		fail("Create corsista fallito");
	}
	}
	
	@Test
	void getByPkTest() {
		try {
			Corsista corsista = CorsistaDAO.getFactory().getByPk(conn,1);
			System.out.println(corsista.toString());
		}catch(SQLException sql) {
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@Test
	void getAll() {
		try {
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			System.out.println(corsisti.toString());
		}catch(SQLException sql) {
			sql.printStackTrace();
			fail("GetAll fallito");
		}
	}
}
