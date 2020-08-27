package datos;

import java.io.*;
import java.util.*;
import Excepciones.AccesoDatosEx;
import Excepciones.EscrituraDatosEx;
import Excepciones.LecturaDatosEx;
import domain.Peliculas;

public class AccesoDatosImpl implements IAccesoDatos {

	@Override
	public boolean existe(String nombreArchivo) throws AccesoDatosEx {
		File archivo = new File(nombreArchivo);
		return archivo.exists();
	}

	@Override
	public List<Peliculas> listar(String nombreArchivo) throws LecturaDatosEx {
		File archivo = new File(nombreArchivo);
		List<Peliculas> pelicula = new ArrayList<>();
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			while (linea != null) {
				Peliculas peliculas = new Peliculas(linea);
				((List<Peliculas>) pelicula).add(peliculas);
				linea = entrada.readLine();
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al listar peliculas: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al listar peliculas: " + e.getMessage());
		}
		return pelicula;
	}

	@Override
	public void escribir(Peliculas pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.toString());
			salida.close();
			System.out.println("Se ha escrito informacion al archivo " + pelicula);
		} catch (IOException e) {
			e.printStackTrace();
			throw new EscrituraDatosEx("Excepcion al escribir peliculas" + e.getMessage());
		}
	}

	@Override
	public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
		File archivo = new File(nombreArchivo);
		String resultado = null;
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			int indi = 1;
			while (linea != null) {
				if (buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula " + linea + "encontrada en el indice" + indi;
					break;
				}
				linea = entrada.readLine();
				indi++;
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar pelicula: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar pelicula: " + e.getMessage());
		}
		return resultado;
	}

	@Override
	public void crear(String nombreArchivo) throws AccesoDatosEx {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se ha creado el archivo");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("Excepcion al crear pelicula: " + e.getMessage());
		}
	}

	@Override
	public void borrar(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		if (archivo.exists())
			archivo.delete();
		System.out.print("Se ha eliminado el archivo" + nombreArchivo);
	}
}