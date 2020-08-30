package Presentacion;

import java.util.*;
import servicio.*;

public class CatalogoPeliculasPresentacion {

	public static void main(String[] args) {
		int opcion = 10;
		Scanner teclado = new Scanner(System.in);
		ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

		while (opcion != 0) {
			System.out.println("Elige una opcion: \n" + "1. Iniciar catalogo peliculas\n" + "2. Agregar pelicula \n"
					+ "3. Listar peliculas \n" + "4. Buscar peliculas \n" + "0. Salir");
			opcion = Integer.parseInt(teclado.nextLine());

			switch (opcion) {
			case 1:
				catalogo.iniciarCatalogoPeliculas();
				break;
			case 2:
				System.out.println("Introduzca la pelicula: \n");
				catalogo.agregarPeliculas(teclado.nextLine());
				break;
			case 3:
				catalogo.listarPeliculas();
				break;
			case 4:
				System.out.print("introduzca la pelicula que desea buscar: \n");
				catalogo.buscarPeliculas(teclado.nextLine());
				break;
			case 0:
				System.out.print("Hasta luego.");
				break;
			default:
				System.out.print("Opcion invalida.");
				break;
			}
		}
	}
}
