package com.financeiro.Financeiro.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.financeiro.Financeiro.entidades.Conta;
import com.financeiro.Financeiro.servicos.ContaServicos;

import jakarta.servlet.Servlet;

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

	@PostMapping
	public ResponseEntity<Conta> inserir(@RequestBody Conta obj){
		
		obj = contaServicos.inserirConta(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
		
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		contaServicos.delete(id);
		
		
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Conta> atualizar(@PathVariable Long id,@RequestBody Conta obj){
		
		obj = contaServicos.atualizar(id, obj);
		
		return ResponseEntity.ok().body(obj);
		
	}
	

}
