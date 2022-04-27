//CLASE CREADA POR JOAN SALAS 27/04
package com.ludoteca.arkham.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esta excepcion es una excepcion personalizada que saltará el no existir un juego
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ExcepcionRecursoNoEncontrado extends RuntimeException{
	
	private static final long serialVersionID = 1L;
	
	public ExcepcionRecursoNoEncontrado(String mensaje) {
		super(mensaje);
	}
	
}
