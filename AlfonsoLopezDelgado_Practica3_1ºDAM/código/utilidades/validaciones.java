package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class validaciones {
	/**
	 * Método encargado de recoger y posterior validdación de la opción escogida por
	 * el usuario para la elección de la opción del menú mediante números
	 *
	 * @return Devuelve un int que será la opción escogida por el usuario
	 */
	public static int pedirNum() {
		Scanner lector = new Scanner(System.in);
		int num = lector.nextInt();
		try {
			while (num < 1 || num > 5) {
				System.out.println("Error vuelva a elegir una opcion");
				num = lector.nextInt();
			}
		} catch (Exception e) {

		}
		return num;
	}

	/**
	 * Método encargado de recoger la cadena introducida por el usuario y no vacia
	 *
	 * @return Devuelve una cadena de texto
	 */
	public static String pedirTexto() {

		Scanner lector = new Scanner(System.in);
		String texto = "";
		texto = lector.nextLine();

		while (texto.isEmpty()) {
			System.out.println("No ha introducido ningún dato");
			texto = lector.nextLine();

		}

		return texto;
	}

	/**
	 * Método encargado de recoger el dato introducido por el usuario y
	 * posteriormente validado dentro de los criterios establecidos
	 *
	 * @return Devuelve un float validado
	 */
	public static float pedirVal() {
		Scanner lector = new Scanner(System.in);
		float num = 0;
		boolean encontrado = false;
		while (!encontrado) {
			try {
				do {
					num = lector.nextFloat();
					if (num < 0 || num > 10) {
						System.out.println(
								"El valor introducido no está dentro de los valores establecidos que son (0-10)");
					}
				} while (num < 0 || num > 10);
				encontrado = true;
			} catch (InputMismatchException e) {
				System.out.println("El dato no es numérico vuelva a introducirlo");
				lector.next();
			}
		}
		return num;
	}

	/**
	 * Método que se encarga de verificar que la fecha que ha introducido el usuario
	 * por consola sea válida
	 * 
	 * @return Devuelve una fecha en tipo String
	 */

	public static String pedirFecha() {
		String fecha = "";
		int longitud;
		String cadena = "1234567890";
		boolean encontrado;
		try {
			do {
				encontrado = false;
				fecha = pedirTexto();
				longitud = fecha.length();

				for (int i = 0; i < longitud && !encontrado; i++) {
					if (cadena.indexOf(fecha.charAt(i)) == -1) {
						encontrado = true;
						System.out.println("El valor introducido no es numerico vuelve a introducirlo");
					} else if (longitud != 4) {
						System.out.println("La longitud no es la correcta vuelva a introducir la fecha");
						encontrado = true;
					}
				}
			} while (encontrado || longitud != 4);
		} catch (Exception e) {

		}
		return fecha;
	}

}
