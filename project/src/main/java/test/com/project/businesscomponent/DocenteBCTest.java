package test.com.project.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.project.architecture.dao.DocenteDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class DocenteBCTest {
	private static final DocenteDAO DocentiDAO = null;
	private static Connection conn;
	private static Docente docente;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		docente = new Docente();
		docente.setNomeDocente("Maria");
		docente.setCognomeDocente("Gallina");
		docente.setCvDocente(1);
		docente.setcodDocente(2);

	}

	private Object docenti;

	@Test
	@Order(1)
	void createTest() {
		try {
			DocenteDAO.getFactory().create(conn, docente);
			System.out.println("Docente creato");
		} catch (SQLException sql) {
			sql.printStackTrace();
			fail("Docente non creato");
		}
	}

	@Test
	@Order(2)
	void getByPkTest() {
		try {
			Docente docente = DocenteDAO.getFactory().getByPk(conn, 1);
			System.out.println(docente.toString());
		} catch (SQLException sql) {
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}

	@Test
	@Order(3)
	void getAll() {
		try {
			Docente[] Docenti = DocentiDAO.getFactory().getAll(conn);
			System.out.println(docenti.toString());
		} catch (SQLException sql) {
			sql.printStackTrace();
			fail("GetAll fallito");
		}
	}

	@Test
	@Order(4)
	void docenteTot() {
		try {
			int docente = DocenteDAO.getFactory().docenteTot(conn);
			System.out.println(docente);
		} catch (SQLException sql) {
			sql.printStackTrace();
			fail("Count errato");
		}
	}
}
