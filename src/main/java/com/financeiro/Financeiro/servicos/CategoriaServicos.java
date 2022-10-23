package com.financeiro.Financeiro.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.Financeiro.entidades.Categoria;
import com.financeiro.Financeiro.repositorios.CategoriaRepositorios;

@Service
public class CategoriaServicos {
	
	@Autowired
	private CategoriaRepositorios contaRepositorios;
	
	public List<Categoria> procurarTodos(){
		
		return contaRepositorios.findAll();
	}
	
	

	public Categoria procurarPorId(Long id) {
		
		Optional<Categoria> obj =  contaRepositorios.findById(id);
		
		return obj.get();
	}
	
	
}
