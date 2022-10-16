package com.financeiro.Financeiro.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.Financeiro.entidades.Conta;

@RestController
@RequestMapping(value = "/contas")
public class ContaRecursos {
	
	
	
	@GetMapping
	public ResponseEntity<Conta> procurarTodos(){
		
		Conta c = new Conta(1L, "DDDD", "DDDDF");
		return ResponseEntity.ok().body(c);
		
		
	}
	

}
