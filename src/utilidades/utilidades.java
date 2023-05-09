package utilidades;

import java.util.InputMismatchException;
import datos.sql;
import datos.Pelicula;

public class utilidades {
	/**
	 * Menu gráfico y tabla switch que contienen los métodos para interactuar con el
	 * menú CRUD El menú está controlado por las funciones try-catch para controlar
	 * las excepciones surgidas en la interacción del usuario-maquina Además crea un
	 * objeto de la clase ListaPeliculas para el almacenamiento de los objetos de la
	 * clase "Peliculas"
	 */
	public static void menu() {
		int eleccion = 0;
		String texto="";
		do {
			try {
				System.out.println("-------------------------");
				System.out.println("| 1 |    CREAR	    	|");
				System.out.println("-------------------------");
				System.out.println("| 2 |	MODIFICAR   	|");
				System.out.println("-------------------------");
				System.out.println("| 3 |	 BORRAR	    	|");
				System.out.println("-------------------------");
				System.out.println("| 4 |	CONSULTAR	|");
				System.out.println("-------------------------");
				System.out.println("| 5 |     SALIR		|");
				System.out.println("-------------------------");

				eleccion = validaciones.pedirNum();
				switch (eleccion) {
				case 1:
					sql.crearPeli(caracteristicasPeli("Introduce una pelicula"));
					break;
				case 2:
					System.out.println("Que pelicula desea modificar");
					texto=sql.buscar(validaciones.pedirTexto());
					if(texto!="nulo") {
					sql.ModificarPeli(texto);
					}
					break;
				case 3:
					System.out.println("Que pelicula desea borrar");
					sql.BorrarPeli(validaciones.pedirTexto());
					break;
				case 4:
					System.out.println("Que pelicula desea buscar");
					sql.buscar(validaciones.pedirTexto());
					break;
				default:
					System.out.println("GRACIAS por volver a corregir a MiniMestri =D");

				}
			} catch (NullPointerException e) {
				System.out.println("ERROR de almacenamiento");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("ERROR de almacenamiento");
			} catch (InputMismatchException e) {
				System.out.println("El valor introducido no es numerico, vuelva a introducir un valor correcto");
			} catch (Exception e) {
				System.out.println("ERROR");
			}
		} while (eleccion != 5);

	}

	/**
	 * Método para crear un objeto de la clase "Peliculas" con sus respectivos
	 * atributos
	 *
	 * @param texto Cadena de texto que sirve como enunciado
	 * @return Un objeto de la clase "Peliculas" que será ingresado, mediante otros
	 *         métodos, en el arraylist "contenedor" de la clase "ListaPeliculas
	 */
	public static Pelicula caracteristicasPeli(String texto) {
		String nombre = "";
		String fecha = "";
		String genero = "";
		float valoracion = 0;

		System.out.println(texto);
		System.out.println("Nombre: ");
		nombre = validaciones.pedirTexto();
		System.out.println("Fecha: ");
		fecha = validaciones.pedirFecha();
		System.out.println("Genero: ");
		genero = validaciones.pedirTexto();
		System.out.println("Valoracion: ");
		valoracion = validaciones.pedirVal();

		return new Pelicula(nombre, fecha, genero, valoracion);
	}
}
