package com.financeiro.Financeiro.entidades.enums;

public enum ContaStatus {
	
	A_PAGAR(1),
	EM_ATRASO(2),
	PAGO(3);
	
	
	private int code;
	
	private ContaStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		
		return code;
	}
	
	
	public static ContaStatus valor(int code) {
		
		for(ContaStatus valor : ContaStatus.values() ) {
			if(valor.getCode() == code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Codigo de Conta Status Invalido!!");
		
	}
	
	
}
