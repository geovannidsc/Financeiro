package com.financeiro.Financeiro.servicos.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Recurso não Encontrado. ID "+id);
		
	}
	
	
	
	
	
	
}
