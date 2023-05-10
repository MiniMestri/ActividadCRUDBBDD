package control;

import datos.*;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import utilidades.*
;class JUNIT {

	@Test
	public void CrearPeli() throws ClassNotFoundException, SQLException {
		
		Pelicula peli1= new Pelicula("avatar","2012","ciencia ficcion",7.8f);
		Pelicula peli2= new Pelicula("titanic","1997","romance",4.3f);
		Pelicula peli3= new Pelicula("jurassic","2001","ciencia ficcion",6.9f);
		sql.crearPeli(peli1);
		assertEquals("avatar", peli1.getNombre());
		sql.crearPeli(peli2);
		assertEquals("1997", peli2.getFecha());
		sql.crearPeli(peli3);
		assertEquals(6.9f, peli3.getValoracion());

		

		
	}

}
