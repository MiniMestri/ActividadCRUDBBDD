package datos;

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

	public static void ModificarPeli(String texto, Pelicula peliculas) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 0;
		String sql = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");

			sentenciaSQL = conexion.createStatement();
			sql = "UPDATE peliculas SET nombre='" + peliculas.getNombre() + "',fecha='" + peliculas.getFecha()
					+ "',genero='" + peliculas.getGenero() + "',valoracion=" + peliculas.getValoracion()
					+ " where nombre='" + texto + "'";
			resultado = sentenciaSQL.executeUpdate(sql);

			confirmacion(resultado);

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
		System.out.println("conectado/desconectado");

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

	public static void buscar(String texto) throws SQLException, ClassNotFoundException {

		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado=0;
		String sql = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/crudbbdd", "root", "");
			sentenciaSQL = conexion.createStatement();
			sql = "SELECT * FROM peliculas where nombre='" + texto + "'";

			rs = sentenciaSQL.executeQuery(sql);

			while (rs.next()) {
				System.out.println("id: " + rs.getInt("id") + "nombre: " + rs.getString("nombre") + " fecha: "
						+ rs.getString("fecha") + " genero: " + rs.getString("genero") + " valoracion: "
						+ rs.getFloat("valoracion"));
				resultado++;
			}
			confirmacion(resultado);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
	}
	private static void confirmacion(int num) {
		if (num >= 1) {
			System.out.println("Procedimiento realizado correctamente");
		}else {
			System.out.println("La pelicula no existe");
		}
		
	}

}
