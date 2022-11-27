package com.financeiro.Financeiro.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.financeiro.Financeiro.data.vo.v1.ContaVO;
import com.financeiro.Financeiro.data.vo.v2.ContaVOV2;
import com.financeiro.Financeiro.servicos.ContaServicos;

@RestController
@RequestMapping(value = "/contas")
public class ContaRecursos {

	@Autowired
	private ContaServicos contaServicos;

	@GetMapping
	public ResponseEntity<List<ContaVO>> procurarTodos() {

		List<ContaVO> list = contaServicos.procurarTodos();

		return ResponseEntity.ok().body(list);

	}
	
	

	// @CrossOrigin(origins = {"http://localhost:8080",
	// "http://teste.com.br","http://teste1.com.br"})
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContaVO> procurarPorId(@PathVariable Long id) {

		ContaVO obj = contaServicos.procurarPorId(id);

		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<ContaVO> inserir(@RequestBody ContaVO obj) {

		obj = contaServicos.inserirConta(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}


	@PostMapping(value = "/v2")
	public ResponseEntity<ContaVOV2> inserirV2(@RequestBody ContaVOV2 obj) {

		obj = contaServicos.inserirContav2(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		contaServicos.delete(id);

		return ResponseEntity.noContent().build();
	}

//	@PutMapping(value = "/{id}")
//	public ResponseEntity<ContaVO> atualizar(@PathVariable Long id,@RequestBody ContaVO obj){
//		
//		obj = contaServicos.atualizar(id, obj);
//		
//		return ResponseEntity.ok().body(obj);
//		
//	}

}
