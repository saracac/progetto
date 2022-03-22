package test.com.project.businesscomponent;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.project.architecture.dao.CorsistaDAO;
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
	private static long[] corsi;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		corso = new Corso();
		corso.setCodCorso(16);
		corso.setNomeCorso("Matematica");
		corso.setDataInizio(new GregorianCalendar(2022, 02, 03).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 04, 02).getTime());
		corso.setCommenti("matematica avanzata");
		corso.setCosto(150);
		corso.setAula("33A");
		
		corsi1 = new Corso();
		corsi1.setCodCorso(17);
		corsi1.setNomeCorso("Informatica");
		corsi1.setDataInizio(new GregorianCalendar(2022, 01, 10).getTime());
		corsi1.setDataFine(new GregorianCalendar(2022, 02, 13).getTime());
		corsi1.setCommenti("informatica base");
		corsi1.setCosto(300);
		corsi1.setAula("12B");
		
		corsi2 = new Corso();
		corsi2.setCodCorso(18);
		corsi2.setNomeCorso("Scienze");
		corsi2.setDataInizio(new GregorianCalendar(2022, 03, 01).getTime());
		corsi2.setDataFine(new GregorianCalendar(2022, 05, 23).getTime());
		corsi2.setCommenti("Scienze intermedie");
		corsi2.setCosto(500);
		corsi2.setAula("18C");
		
		corsi = new long[2];
		
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
		CorsistaDAO.getFactory().create(conn, corsista);
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
			System.out.println("Corsi corsista:");
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
