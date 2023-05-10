package datos;

/**
 * Clase "Pelicula" que contiene el constructor, getters y setters, y toString
 * para la creación del objeto "Peliculas". Tiene cuatro atributos, uno más que
 * la práctica anterior para dar más dinamismo a la práctica, los cuales el
 * atributo "presupuesto" tiene la función de generar un número aleatorio.
 *
 * @author Alfonso Lopez delgado
 */
public class Pelicula {

	private String nombre;
	private String fecha;
	private String genero;
	private float valoracion;

	/**
	 * Constructor del objeto "Peliculas"
	 *
	 * @param nombre     Tipo String, para almacenar el nombre de la película del
	 *                   objeto "Pelicula"
	 * @param fecha      Tipo String, para almacenar la fecha de la película del
	 *                   objeto "Pelicula"
	 * @param genero     Tipo String, para almacenar el genero de la película del
	 *                   objeto "Pelicula"
	 * @param valoracion Tipo float, para almacenar la valoración de la película del
	 *                   objeto "Pelicula"
	 */
	public Pelicula(String nombre, String fecha, String genero, float valoracion) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.genero = genero;
		this.valoracion = valoracion;
	}

	/**
	 * Getter del objeto "Pelicula" que muestra el nombre de la película
	 *
	 * @return Devuelve el nombre del objeto de tipo String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter del objeto "Pelicula" que establece el valor del nombre de la película
	 *
	 * @param nombre Introduce una cadena de tipo String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Setter del objeto "Pelicula" que establece el valor de la fecha de la
	 * película
	 *
	 * @param fecha Introduce una cadena de tipo String
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Setter del objeto "Pelicula" que establece el valor de la fecha de la
	 * película
	 *
	 * @param fecha Introduce una cadena de tipo String
	 */

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Getter del objeto "Pelicula" que muestra el género de la película
	 *
	 * @return Devuelve el genero del objeto tipo String
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Setter del objeto "Pelicula" que establece el valor del genero de la película
	 *
	 * @param fecha Introduce una cadena de tipo String
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Getter del objeto "Peliculas" que muestra la valoración de la película
	 *
	 * @return Devuelve la valoracion del objeto tipo float
	 */
	public float getValoracion() {
		return valoracion;
	}

	/**
	 * Setter del objeto "Peliculas" que establece el valor numérico de la
	 * valoración de la película
	 *
	 * @param valoracion Introduce un valor de tipo float
	 */
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	/**
	 *
	 * @return Devuelve cadena String con el resultado almacenado del objeto
	 *         "Pelicula"
	 */
	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", fecha=" + fecha + ", genero=" + genero + ", valoracion=" + valoracion
				+ "]";
	}

}
