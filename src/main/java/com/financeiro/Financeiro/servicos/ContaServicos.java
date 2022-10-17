package com.financeiro.Financeiro.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.financeiro.Financeiro.entidades.Conta;
import com.financeiro.Financeiro.repositorios.ContaRepositorios;

@Service
public class ContaServicos {
	
	@Autowired
	private ContaRepositorios contaRepositorios;
	
	public List<Conta> procurarTodos(){
		
		return contaRepositorios.findAll();
	}
	
	

	public Conta procurarPorId(Long id) {
		
		Optional<Conta> obj =  contaRepositorios.findById(id);
		
		return obj.get();
	}
	
	
}
