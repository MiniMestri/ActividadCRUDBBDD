package control;

import utilidades.utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controlador {


			public static void main(String[] args) throws ClassNotFoundException {
				// TODO Auto-generated method stub
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost",
							"root", "");

					conexion.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					//System.out.println("Error");
				}
				
				System.out.println("Conectado/desconectado");
				

			}

	

}
