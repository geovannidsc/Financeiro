package com.financeiro.Financeiro.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.Financeiro.entidades.Conta;
import com.financeiro.Financeiro.servicos.ContaServicos;

@RestController
@RequestMapping(value = "/contas")
public class ContaRecursos {

	@Autowired
	private ContaServicos contaServicos;

	@GetMapping
	public ResponseEntity<List<Conta>> procurarTodos() {

		List<Conta> list = contaServicos.procurarTodos();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Conta> procurarPorId(@PathVariable Long id) {

		Conta obj = contaServicos.procurarPorId(id);

		return ResponseEntity.ok().body(obj);

	}



}
