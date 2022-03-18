package test.com.project.businesscomponent;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.project.architecture.dao.CorsoDAO;
import com.project.businesscomponent.CorsoBC;
import com.project.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest 
{
	private static Corso corso, corso2;
	private static Corso[] corsi;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setCodCorso(20);
		corso.setNomeCorso("Matematica");
		corso.setDataInizio(new Date());
		corso.setDataFine(new Date());
		corso.setCosto(150.00);
		corso.setCommenti("matematica avanzata");
		corso.setAula((short) 33);
		
		corso2 = new Corso();
		corso2.setCodCorso(21);
		corso2.setNomeCorso("Informatica");
		corso2.setDataInizio(new Date());
		corso2.setDataFine(new Date());
		corso2.setCosto(300.00);
		corso2.setCommenti("informatica base");
		corso2.setAula((short) 12);
		
		corsi = new Corso[2];
		
		corsi[0] = corso;
		corsi[1] = corso2;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {	
		try {
			CorsoDAO.getFactory().delete(conn, corso); // fallirà sempre se testDeleteCorsi() ha funzionato
			System.out.println("Corso eliminato");
			} catch(SQLException exc) 
			{
				exc.printStackTrace();
				System.out.println(exc.getMessage());
				System.out.println(exc.getCause());
				System.out.println(exc.getErrorCode());
				fail("Eliminazione corso fallita");
			}
	}

	@Test
	@Order(1)
	void testCreateCorso(){
		try {
		CorsoDAO.getFactory().create(conn, corso);
		CorsoDAO.getFactory().create(conn, corso2);
		System.out.println("Corso creato");
		} catch(SQLException exc) 
		{
			exc.printStackTrace();
			System.out.println(exc.getMessage());
			System.out.println(exc.getCause());
			System.out.println(exc.getErrorCode());
			fail("Creazione corso fallita");
		}
	}
	
	@Test
	@Order(2)
	void testGetCorsoByPk() {
		try {
			Corso c = CorsoDAO.getFactory().getByPk(conn, corso.getCodCorso());
			System.out.println("Corso: " + c);
			} catch(SQLException exc)
			{
				exc.printStackTrace();
				System.out.println(exc.getMessage());
				System.out.println(exc.getCause());
				System.out.println(exc.getErrorCode());
				fail("Ottenimento corso fallito");
			}
	}
	
	@Test
	@Order(4)
	void testGetLastDate() {
		try {
			Date d = CorsoDAO.getFactory().getLastDate(conn);
			System.out.println("Data inizio dell'ultimo corso: " + d);
			} catch(SQLException exc)
			{
				exc.printStackTrace();
				System.out.println(exc.getMessage());
				System.out.println(exc.getCause());
				System.out.println(exc.getErrorCode());
				fail("Ottenimento data inizio ultimo corso fallita");
			}
	}
	
	@Test
	@Order(3)
	void testGetAllCorsi() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
			System.out.println("Corsi:");
			for(Corso c : corsi)
				System.out.println(c);
			} catch(SQLException exc)
			{
				exc.printStackTrace();
				System.out.println(exc.getMessage());
				System.out.println(exc.getCause());
				System.out.println(exc.getErrorCode());
				fail("Ottenimento lista corsi fallito");
			}
	}
	
	@Test
	@Order(5)
	void testDeleteCorsi() {
		CorsoBC cBC = new CorsoBC();
		cBC.delete(conn, corsi);
		System.out.println("Corsi rimasti: ");
		try {
			Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
			assert(corsi.length == 0); // dovrebbe cancellarli entrambi
			for(Corso c : corsi) // li cerco di printare per verificare se ha fallito o meno
				System.out.println(c);
			} catch(SQLException exc)
			{
				exc.printStackTrace();
				System.out.println(exc.getMessage());
				System.out.println(exc.getCause());
				System.out.println(exc.getErrorCode());
				fail("Ottenimento lista corsi fallito");
			}
	}
}
