package control;

import datos.*;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

/**
 * Clase donde se realizan las pruebas de JUnit
 * 
 * @author Alfonso Lopez Delgado
 */
class JUNIT {

	/**
	 * Test de prueba del método "CrearPeli" de la clase "sql" Comprobación de que
	 * los atributos del objeto "Pelicula" se introducen correctamente y
	 * comprobación que está dentro de la BBDD
	 * 
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	@Test
	public void CrearPeli() throws ClassNotFoundException, SQLException {

		Pelicula peli1 = new Pelicula("avatar", "2012", "ciencia ficcion", 7.8f);
		Pelicula peli2 = new Pelicula("titanic", "1997", "romance", 4.3f);
		Pelicula peli3 = new Pelicula("jurassic", "2001", "ciencia ficcion", 6.9f);
		sql.crearPeli(peli1);
		assertEquals("avatar", peli1.getNombre());
		sql.crearPeli(peli2);
		assertEquals("1997", peli2.getFecha());

		assertNotEquals(sql.buscar(peli1.getNombre()), "nulo");
		assertNotEquals(sql.buscar(peli2.getNombre()), "nulo");
		assertEquals(sql.buscar(peli3.getNombre()), "nulo");

	}

	/**
	 * He copiado una parte del método "ModificarPeli" ya que he puesto cinco
	 * opciones para introducir por teclado.
	 * 
	 * @param texto Cadena de texto que recibe para buscar la película en la BBDD
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	public void MetodoModificarPeli(String texto) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 1;
		String sql = "";
		Pelicula aux = new Pelicula("fast", "2015", "carreras", 5.8f);
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");

			sentenciaSQL = conexion.createStatement();
			sql = "UPDATE peliculas SET nombre='" + aux.getNombre() + "',fecha='" + aux.getFecha() + "',genero='"
					+ aux.getGenero() + "',valoracion=" + aux.getValoracion() + " where nombre='" + texto + "'";
			resultado = sentenciaSQL.executeUpdate(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();
		}
	}

	/**
	 * 
	 * Test de prueba que verifica la modificación de un registro en la base de
	 * datos
	 * 
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	@Test
	public void ModificarPeli() throws ClassNotFoundException, SQLException {

		Pelicula peli2 = new Pelicula("titanic", "1997", "romance", 4.3f);
		Pelicula aux = new Pelicula("fast", "2015", "carreras", 5.8f);
		MetodoModificarPeli(peli2.getNombre());

		assertNotEquals(sql.buscar(aux.getNombre()), "nulo");
		assertEquals(sql.buscar(peli2.getNombre()), "nulo");

	}

	/**
	 * 
	 * Test de prueba que verifica la eliminación de un registro en la base de datos
	 * 
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	@Test
	public void EliminarPeli() throws ClassNotFoundException, SQLException {
		Pelicula aux = new Pelicula("fast", "2015", "carreras", 5.8f);
		Pelicula peli3 = new Pelicula("jurassic", "2001", "ciencia ficcion", 6.9f);

		assertEquals(sql.buscar(peli3.getNombre()), "nulo");
		sql.crearPeli(peli3);
		assertNotEquals(sql.buscar(peli3.getNombre()), "nulo");
		sql.BorrarPeli(peli3.getNombre());
		assertEquals(sql.buscar(peli3.getNombre()), "nulo");
	}

	/**
	 * 
	 * Test de prueba
	 * 
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	@Test
	public void BuscarPeli() throws ClassNotFoundException, SQLException {
		Pelicula peli1 = new Pelicula("avatar", "2012", "ciencia ficcion", 7.8f);
		Pelicula aux = new Pelicula("fast", "2015", "carreras", 5.8f);

		sql.crearPeli(peli1);
		sql.crearPeli(aux);
		assertNotEquals(sql.buscar(peli1.getNombre()), "nulo");
		assertNotEquals(sql.buscar(aux.getNombre()), "nulo");
		assertEquals(sql.buscar(peli1.getNombre()), "avatar");
		assertEquals(sql.buscar(aux.getNombre()), "fast");

	}
}
