package com.financeiro.Financeiro.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.financeiro.Financeiro.entidades.Categoria;
import com.financeiro.Financeiro.servicos.CategoriaServicos;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {

	@Autowired
	private CategoriaServicos categoriaServicos;

	@GetMapping
	public ResponseEntity<List<Categoria>> procurarTodos() {

		List<Categoria> list = categoriaServicos.procurarTodos();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> procurarPorId(@PathVariable Long id) {

		Categoria obj = categoriaServicos.procurarPorId(id);

		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<Categoria> inserir(@RequestBody Categoria obj) {

		obj = categoriaServicos.inserirCategoria(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

}
