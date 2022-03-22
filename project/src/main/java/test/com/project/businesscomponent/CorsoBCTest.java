package test.com.project.businesscomponent;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.project.architecture.dao.CorsoDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.CorsoBC;
import com.project.businesscomponent.model.Corsista;
import com.project.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest 
{
	private static Corso corso, corsi1, corsi2;
	private static Corsista corsista;
	private static Long[] corsi;
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
		
		corsi1 = new Corso();
		corsi1.setCodCorso(21);
		corsi1.setNomeCorso("Informatica");
		corsi1.setDataInizio(new Date());
		corsi1.setDataFine(new Date());
		corsi1.setCosto(300.00);
		corsi1.setCommenti("informatica base");
		corsi1.setAula((short) 12);
		
		corsi2 = new Corso();
		corsi2.setCodCorso(22);
		corsi2.setNomeCorso("Scienze");
		corsi2.setDataInizio(new Date());
		corsi2.setDataFine(new Date());
		corsi2.setCosto(500.10);
		corsi2.setCommenti("Scienze intermedie");
		corsi2.setAula((short) 18);
		
		corsi = new Long[2];
		
		corsi[0] = corsi1.getCodCorso();
		corsi[1] = corsi2.getCodCorso();
		
		corsista = new Corsista();
		corsista.setCodCorsista(10);
		corsista.setNomeCorsista("Pierpaolina");
		corsista.setCognomeCorsista("Uga");
		corsista.setPrecedentiformativi(12);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {	
		try {
			CorsoDAO.getFactory().delete(conn, corso.getCodCorso());
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
		CorsoDAO.getFactory().create(conn, corsi1);
		CorsoDAO.getFactory().create(conn, corsi2);
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
	void testDataInizioUltimoCorso() {
		try {
			Date d = CorsoDAO.getFactory().dataInizioUltimoCorso(conn);
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
	void testGetCorsiDisp() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getCorsiDisponibili(conn);
			System.out.println("Corsi disponibili:");
			for(Corso c : corsi)
				System.out.println(c);
			} catch(SQLException | ParseException exc)
			{
				exc.printStackTrace();
				System.out.println(exc.getMessage());
				System.out.println(exc.getCause());
				fail("Ottenimento lista corsi disponibili fallito");
			}
	}
	
	@Test
	@Order(6)
	void testGetListaCorsiCorsista() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getCorsiCorsista(conn, corsista.getCodCorsista());
			System.out.println("Corsi disponibili:");
			for(Corso c : corsi)
				System.out.println(c);
			} catch(SQLException exc)
			{
				exc.printStackTrace();
				System.out.println(exc.getMessage());
				System.out.println(exc.getCause());
				fail("Ottenimento lista corsi disponibili fallito");
			}
	}
	
	@Test
	@Order(7)
	void testDeleteCorsi() {
		CorsoBC cBC;
		try {
			cBC = new CorsoBC();
			cBC.deleteCorsi(corsi);
		} catch(SQLException | ClassNotFoundException | IOException exc) 
		{
			exc.printStackTrace();
			System.out.println(exc.getMessage());
			System.out.println(exc.getCause());
			fail("Eliminazione corsi fallita");
		}
		System.out.println("Corsi rimasti: ");
		try {
			Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
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
}
