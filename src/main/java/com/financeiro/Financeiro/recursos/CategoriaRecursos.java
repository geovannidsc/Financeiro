package com.financeiro.Financeiro.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.Financeiro.entidades.Categoria;
import com.financeiro.Financeiro.servicos.CategoriaServicos;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {

	@Autowired
	private CategoriaServicos contaServicos;

	@GetMapping
	public ResponseEntity<List<Categoria>> procurarTodos() {

		List<Categoria> list = contaServicos.procurarTodos();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> procurarPorId(@PathVariable Long id) {

		Categoria obj = contaServicos.procurarPorId(id);

		return ResponseEntity.ok().body(obj);

	}



}
