package com.example.duelocartas.excepcion;

public class InvalidTipoCartaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidTipoCartaException(String message) {
        super(message);
    }
}