package datos;

import utilidades.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase sql donde se almacenarán todas los procesos CRUD y las conexiones con
 * la base de datos MySQL
 * 
 * @author Alfonso Lopez Delgado
 */
public class sql {
	/**
	 * Se encargará, mediante una sentencia INSERT, de insertar los registros en la
	 * base de datos MySQL
	 * 
	 * @param peliculas Objeto de la clase Pelicula
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	public static void crearPeli(Pelicula peliculas) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 0;
		String sql = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");

			sentenciaSQL = conexion.createStatement();

			sql = "INSERT INTO peliculas (id,nombre,fecha,genero,valoracion) VALUES (null,'" + peliculas.getNombre()
					+ "','" + peliculas.getFecha() + "','" + peliculas.getGenero() + "'," + peliculas.getValoracion()
					+ ")";

			resultado = sentenciaSQL.executeUpdate(sql);

			confirmacion(resultado);

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}

	}

	/**
	 * Se encargará, mediante una sentencia UPDATE, de modificar el registro que se
	 * ha introducido por parámetro. Además tendrá tendrá diferentes opciones para
	 * elegir que tipo de columna modificar.
	 * 
	 * @param texto Parametro que servirá como guía en la clausula where de la
	 *              sentencia
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	public static void ModificarPeli(String texto) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 1;
		String sql = "";
		Pelicula pelicula;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");

			sentenciaSQL = conexion.createStatement();

			System.out.println("(1) Modificar TODO");
			System.out.println("(2) Modificar NOMBRE");
			System.out.println("(3) Modificar FECHA");
			System.out.println("(4) Modificar GENERO");
			System.out.println("(5) Modificar VALORACION");

			switch (validaciones.pedirNum()) {
			case 1:
				pelicula = utilidades.caracteristicasPeli("Introduzca los nuevos datos");
				sql = "UPDATE peliculas SET nombre='" + pelicula.getNombre() + "',fecha='" + pelicula.getFecha()
						+ "',genero='" + pelicula.getGenero() + "',valoracion=" + pelicula.getValoracion()
						+ " where nombre='" + texto + "'";
				break;
			case 2:
				System.out.println("Introduce el nuevo nombre");

				sql = "UPDATE peliculas SET nombre='" + validaciones.pedirTexto() + "' where nombre='" + texto + "'";
				break;
			case 3:
				System.out.println("Introduce la nueva fecha");
				sql = "UPDATE peliculas SET fecha='" + validaciones.pedirFecha() + "' where nombre='" + texto + "'";

				break;
			case 4:
				System.out.println("Introduce el nuevo genero");
				sql = "UPDATE peliculas SET genero='" + validaciones.pedirTexto() + "' where nombre='" + texto + "'";

				break;
			case 5:
				System.out.println("Introduce la nueva valoracion");
				sql = "UPDATE peliculas SET valoracion='" + validaciones.pedirVal() + "' where nombre='" + texto + "'";

			}

			resultado = sentenciaSQL.executeUpdate(sql);

			confirmacion(resultado);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}

	}

	/**
	 * Se encargará, mediante la sentencia DELETE, de eleiminar los registros con
	 * ayuda del parámetro intrducido en la clausula where
	 * 
	 * @param texto Parámetro que servirá como guía en la clausula where de la
	 *              sentencia
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 */
	public static void BorrarPeli(String texto) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 0;
		String sql = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");

			sentenciaSQL = conexion.createStatement();
			sql = "DELETE FROM peliculas where nombre='" + texto + "'";

			resultado = sentenciaSQL.executeUpdate(sql);

			confirmacion(resultado);

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
	 * Se encargará de buscar un registro en la base de datos, mediante la consulta
	 * SELECT. Además tomará en cuenta si el registro existe o no, para ayudar al
	 * método ModificarPeli()
	 * 
	 * @param texto Recibirá un parámetro para ayudar a la clausula where de la
	 *              sentencia
	 * @return El nombre que se ha introducido en la clausula where para ayudar al
	 *         método ModificarPeli()
	 * @throws SQLException           Excepcion que lanza java por un error al
	 *                                interactuar con SQL
	 * @throws ClassNotFoundException Excepción que lanza cuando la máquina no
	 *                                encuentra una clase específica
	 */
	public static String buscar(String texto) throws SQLException, ClassNotFoundException {

		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado = 0;
		String sql = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");
			sentenciaSQL = conexion.createStatement();
			sql = "SELECT * FROM peliculas where nombre='" + texto + "'";

			rs = sentenciaSQL.executeQuery(sql);

			while (rs.next()) {
				System.out.println("NOMBRE: " + rs.getString("nombre") + ", FECHA: " + rs.getString("fecha")
						+ ", GENERO: " + rs.getString("genero") + " y VALORACION: " + rs.getFloat("valoracion"));
				resultado++;

			}
			if (resultado == 0) {
				texto = "nulo";
			}
			confirmacion(resultado);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
		return texto;
	}

	/**
	 * Método que sirve para lanzar un mensaje por consola, existe o no el registro
	 * en la base de datos
	 * 
	 * @param num Recibirá un numero que le proporcionará otros métodos para
	 *            comprobar si existo o no el registro
	 */
	private static void confirmacion(int num) {
		if (num >= 1) {
			System.out.println("Procedimiento realizado correctamente");
		} else {
			System.out.println("La pelicula no existe");
		}

	}

}
