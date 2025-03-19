package com.example.duelocartas.excepcion;

public class InvalidTipoMonstruoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidTipoMonstruoException(String message) {
        super(message);
    }
}