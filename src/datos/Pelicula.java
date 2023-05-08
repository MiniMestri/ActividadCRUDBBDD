package datos;

public class Pelicula {

		private String nombre;
		private String fecha;
		private String genero;
		private float valoracion;
		public Pelicula(String nombre, String fecha, String genero, float valoracion) {
			super();
			this.nombre = nombre;
			this.fecha = fecha;
			this.genero = genero;
			this.valoracion = valoracion;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public float getValoracion() {
			return valoracion;
		}
		public void setValoracion(float valoracion) {
			this.valoracion = valoracion;
		}
		@Override
		public String toString() {
			return "Pelicula [nombre=" + nombre + ", fecha=" + fecha + ", genero=" + genero + ", valoracion="
					+ valoracion + "]";
		}
		
		
		
}
