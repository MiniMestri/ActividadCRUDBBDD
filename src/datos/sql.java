package datos;

import utilidades.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql {

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
			System.out.println("(4) Modificar VALORACION");
			System.out.println("(5) Modificar PRESUPUESTO");

			switch (validaciones.pedirNum()) {
			case 1:
				pelicula = utilidades.caracteristicasPeli("Introduzca los nuevos datos");
				sql = "UPDATE peliculas SET nombre='" + pelicula.getNombre() + "',fecha='" + pelicula.getFecha()
						+ "',genero='" + pelicula.getGenero() + "',valoracion=" + pelicula.getValoracion()
						+ " where nombre='" + texto + "'";

				confirmacion(resultado);

				break;
			case 2:
				System.out.println("Introduce el nuevo nombre");

				sql = "UPDATE peliculas SET nombre='" + validaciones.pedirTexto() + "' where nombre='" + texto + "'";
				confirmacion(resultado);
				break;
			case 3:
				System.out.println("Introduce la nueva fecha");
				sql = "UPDATE peliculas SET fecha='" + validaciones.pedirFecha() + "' where nombre='" + texto + "'";
				confirmacion(resultado);

				break;
			case 4:
				System.out.println("Introduce el nuevo genero");
				sql = "UPDATE peliculas SET genero='" + validaciones.pedirTexto() + "' where nombre='" + texto + "'";
				confirmacion(resultado);
				break;
			default:
				System.out.println("Introduce la nueva valoracion");
				sql = "UPDATE peliculas SET nombre='" + validaciones.pedirVal() + "' where nombre='" + texto + "'";
				confirmacion(resultado);

			}
			resultado = sentenciaSQL.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}

	}

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

	private static void confirmacion(int num) {
		if (num >= 1) {
			System.out.println("Procedimiento realizado correctamente");
		} else {
			System.out.println("La pelicula no existe");
		}

	}
	private static void conexion(Connection conexion, Statement sentenciaSQL) throws SQLException, ClassNotFoundException {
		conexion = null;
		sentenciaSQL = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");
		sentenciaSQL = conexion.createStatement();
	}

}
