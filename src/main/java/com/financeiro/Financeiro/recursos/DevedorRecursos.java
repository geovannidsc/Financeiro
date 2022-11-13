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

import com.financeiro.Financeiro.entidades.Devedor;
import com.financeiro.Financeiro.servicos.DevedorServicos;

@RestController
@RequestMapping(value = "/devedores")
public class DevedorRecursos {

	@Autowired
	private DevedorServicos devedorServicos;

	@GetMapping
	public ResponseEntity<List<Devedor>> procurarTodos() {

		List<Devedor> list = devedorServicos.procurarTodos();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Devedor> procurarPorId(@PathVariable Long id) {

		Devedor obj = devedorServicos.procurarPorId(id);

		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<Devedor> inserir(@RequestBody Devedor obj) {

		obj = devedorServicos.inserirDevedor(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

}
