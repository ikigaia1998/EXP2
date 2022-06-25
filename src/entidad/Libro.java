package entidad;

public class Libro {
		private int idLibro;
		private String titulo;
		private String anio;
		private String serie;
		private String categoria;
		private String pais;
		private String tipo;
		
		//GET AND SET
		
		public int getIdLibro() {
			return idLibro;
		}
		public void setIdLibro(int idLibro) {
			this.idLibro = idLibro;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getAnio() {
			return anio;
		}
		public void setAnio(String anio) {
			this.anio = anio;
		}
		public String getSerie() {
			return serie;
		}
		public void setSerie(String serie) {
			this.serie = serie;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
	
		
}