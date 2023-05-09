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

	/**
	 * Método que genera un número aleatorio de 10.000.000-100.000.000. Se
	 * transforma en un String para que posteriormente se ha más facil la
	 * modificación estética del número mediante funciones substring
	 *
	 * @return Devuelve un int en una cadena de texto
	 */
	public static String presupuestoRandom() {
		String cadena = Integer.toString((int) (Math.random() * 90000000 + 10000000));
		return cadena;
	}

	/**
	 * Método que sirve para generar por teclado un número que el usuario elija
	 * 
	 * @return Devuelve un int en una cadena de texto
	 */

	public static String presupuestoMano() {
		int num = 0;
		int contador = 0;
		Scanner lector = new Scanner(System.in);
		try {
			while (num < 9999999 || num > 999999999) {
				if (contador != 0) {
					System.out.println("El numero es incorrecto (10.000.000-100.000.000");
				}
				num = lector.nextInt();
				contador++;
			}
		} catch (Exception e) {

		}

		return Integer.toString(num);
	}
}
