package test.com.project.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import com.project.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void test() {
		try {
			DBAccess.getConnection();
			
			
			
		} catch (SQLException |ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nell apertura della connessione");
		}finally {
			try {
				DBAccess.closeConnection();
			} catch (SQLException e) {
				fail("Errore nella chiusura della connessione");
			}
			
		}
	}

}
