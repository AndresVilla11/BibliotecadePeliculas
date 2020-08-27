package datos;

import java.util.List;
import Excepciones.*;
import domain.Peliculas;

public interface IAccesoDatos {
	
	boolean existe(String nombreArchivo) throws AccesoDatosEx;
	
	List<Peliculas> listar(String nombreArchivo) throws LecturaDatosEx;
	
	void escribir(Peliculas pelicula, String nomnreArchivo, boolean anexar) throws EscrituraDatosEx;
	
	String buscar (String nombreArchivo, String buscar) throws LecturaDatosEx;
	
	void crear(String nombreArchivo) throws AccesoDatosEx;
	
	void borrar(String nombreArchivo) throws AccesoDatosEx;
}
