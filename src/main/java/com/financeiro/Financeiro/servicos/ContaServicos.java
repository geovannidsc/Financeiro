package com.financeiro.Financeiro.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.Financeiro.entidades.Conta;
import com.financeiro.Financeiro.repositorios.ContaRepositorios;

@Service
public class ContaServicos {

	@Autowired
	private ContaRepositorios contaRepositorios;

	public List<Conta> procurarTodos() {

		return contaRepositorios.findAll();
	}

	public Conta procurarPorId(Long id) {

		Optional<Conta> obj = contaRepositorios.findById(id);

		return obj.get();
	}

	public Conta inserirConta(Conta obj) {

		return contaRepositorios.save(obj);

	}
	
	
	public void delete(Long id) {
		
	contaRepositorios.deleteById(id);
		
	}
	
	
	public Conta atualizar(Long id, Conta obj) {
		Conta entity = contaRepositorios.getReferenceById(id);
		atualizarDados(entity, obj);
		
		return contaRepositorios.save(entity);
		
	}

	private void atualizarDados(Conta entity, Conta obj) {
		
		entity.setNome(obj.getNome());
		//entity.setContaStatus(obj.getContaStatus());
		//entity.setdescricao(obj.getdescricao());
		//entity.setDataRegistro(obj.getDataRegistro());
	}
	

}
