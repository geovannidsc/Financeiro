package com.financeiro.Financeiro.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.Financeiro.entidades.Categoria;
import com.financeiro.Financeiro.repositorios.CategoriaRepositorios;
import com.financeiro.Financeiro.servicos.exception.ResourceNotFoundException;

@Service
public class CategoriaServicos {

	@Autowired
	private CategoriaRepositorios categoriaRepositorios;

	public List<Categoria> procurarTodos() {

		return categoriaRepositorios.findAll();
	}

	public Categoria procurarPorId(Long id) {

		Optional<Categoria> obj = categoriaRepositorios.findById(id);

		return obj.orElseThrow( ()-> new ResourceNotFoundException(id));
	}

	public Categoria inserirCategoria(Categoria obj) {

		return categoriaRepositorios.save(obj);

	}
	
	
	public void delete(Long id) {
		
	categoriaRepositorios.deleteById(id);
		
	}
	
	
	public Categoria atualizar(Long id, Categoria obj) {
		Categoria entity = categoriaRepositorios.getReferenceById(id);
		atualizarDados(entity, obj);
		
		return categoriaRepositorios.save(entity);
		
	}

	private void atualizarDados(Categoria entity, Categoria obj) {
		
		entity.setNome(obj.getNome());
		//entity.setCategoriaStatus(obj.getCategoriaStatus());
		//entity.setdescricao(obj.getdescricao());
		//entity.setDataRegistro(obj.getDataRegistro());
	}
	

}
