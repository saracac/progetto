		package test.com.project.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.project.businesscomponent.CorsoCorsistaBC;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaBCTest {
	static long codCorso1;
	static long codCorso2;
	static long codCorsista1;
	static long codCorsista2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		codCorso1=5;
		codCorso2=6;
		codCorsista1=7;
		codCorsista2=8;
	}
	
	@Order(1)
	@Test
	void testCreate()  {
		try{
		CorsoCorsistaBC ccBC=new CorsoCorsistaBC();
		ccBC.create(codCorso1,codCorsista1);
		ccBC.create(codCorso1,codCorsista2);
		ccBC.create(codCorso2,codCorsista2);
		System.out.println("create ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail();
		}
	}
	@Order(4)
	@Test
	void testDelete() {
		try {
			CorsoCorsistaBC ccBC=new CorsoCorsistaBC();
			ccBC.delete(codCorso1,codCorsista1);
			ccBC.delete(codCorso1,codCorsista2);
			ccBC.delete(codCorso2,codCorsista2);

			System.out.println("delete ok");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail();
		}
	}
	@Order(3)
	@Test
	void testGetCorsista() {
		try {
			CorsoCorsistaBC ccBC=new CorsoCorsistaBC();
			long corsista[]=ccBC.getCorsistaByCorso(codCorso1);
			for(long c:corsista)
				System.out.println(c+"\t");

			System.out.println("getCorsista ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail();
		}
	}
	@Order(2)
	@Test
	void testGetCorso() {
		try {
			CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
			long[] corso = ccBC.getCorsoByCorsista(codCorsista1);
			for(long c : corso)
				System.out.println(c);

			System.out.println("getCorso ok");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	
}
