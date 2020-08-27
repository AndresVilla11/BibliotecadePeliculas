package servicio;

public interface ICatalogoPeliculas {
	
	String NOMBRE = "Peliculas.txt";
	
	void agregarPeliculas (String nombrePeliculas);
	
	void listarPeliculas();
	
	void buscarPeliculas(String buscar);
	
	void iniciarCatalogoPeliculas();
	
}
