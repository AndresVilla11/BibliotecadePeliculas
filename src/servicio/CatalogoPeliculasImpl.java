package servicio;

import java.util.List;
import Excepciones.AccesoDatosEx;
import Excepciones.LecturaDatosEx;
import datos.*;
import domain.*;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
	
	private final IAccesoDatos datos;


	
	public CatalogoPeliculasImpl() {
		this.datos = new AccesoDatosImpl();
	}
	
	@Override
	public void agregarPeliculas(String nombrePeliculas) {
		Peliculas pelicula = new Peliculas(nombrePeliculas);
		boolean anexar = false;
		try {
			anexar = datos.existe(NOMBRE);
			datos.escribir(pelicula, NOMBRE, anexar);
		} catch (AccesoDatosEx e) {
			System.out.println("Error de acceso a datos");
			e.printStackTrace();
		}
	}

	@Override
	public void listarPeliculas() {
		try {
			List<Peliculas> peliculas = this.datos.listar(NOMBRE);
			for(Peliculas pelicula: peliculas) {
				System.out.println("Pelicula= "+ pelicula);
			}
		} catch (LecturaDatosEx e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buscarPeliculas(String buscar) {
		String resultado = null;
		try {
			resultado = this.datos.buscar(NOMBRE, buscar);
			
		} catch (LecturaDatosEx e) {
			e.printStackTrace();
		}
		System.out.print("Resultado= " + resultado);
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		try {
			if(this.datos.existe(NOMBRE)) {
				datos.borrar(NOMBRE);
				datos.crear(NOMBRE);
			}else {
				datos.crear(NOMBRE);
			}
		} catch (AccesoDatosEx e) {
			e.printStackTrace();
		}
	}
}
