package dominio;

import java.util.Date;

import actions.*;
import dominio.excepcion.PrestamoException;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;

public class Bibliotecario {
	//initialize variable
	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";

	private RepositorioLibro repositorioLibro;
	private RepositorioPrestamo repositorioPrestamo;

	public Bibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
		this.repositorioLibro = repositorioLibro;
		this.repositorioPrestamo = repositorioPrestamo;

	}

	public void prestar(String isbn,String nombreUsuario) {

		//throw new UnsupportedOperationException("Método pendiente por implementar");
	
		Libro libro = repositorioLibro.obtenerPorIsbn(isbn);

		if (libro != null) {//libro exist?
			
			if (Palindroma.IsPalindroma(isbn)) {//is palindroma?
				throw new PrestamoException("los libros palíndromos solo se pueden utilizar en la biblioteca");//show msg
			} else {
				//load Libro prestado
				Libro libroP = repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn);

				if (libroP != null) {// book not available?
					throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
				} else {
					//get FechaEntregamaxima
					Date fechaEntregaMaxima = Palindroma.getDateMax(isbn);
					//new object of class Prestamo with initial var
					Prestamo p = new Prestamo(new Date(), libro, fechaEntregaMaxima, nombreUsuario);
					//use method agregar
					repositorioPrestamo.agregar(p);
				}

			}

		}

	}

	public boolean esPrestado(String isbn) {
		
		Libro l = repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn);
		
		 if (l!=null){
			 
			 return true;
		 }
		return false;
	}

}
