package com.financeiro.Financeiro.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.Financeiro.entidades.Devedor;
import com.financeiro.Financeiro.repositorios.DevedorRepositorios;
import com.financeiro.Financeiro.servicos.exception.ResourceNotFoundException;

@Service
public class DevedorServicos {

	@Autowired
	private DevedorRepositorios devedorRepositorios;

	public List<Devedor> procurarTodos() {

		return devedorRepositorios.findAll();
	}

	public Devedor procurarPorId(Long id) {

		Optional<Devedor> obj = devedorRepositorios.findById(id);

		return obj.orElseThrow( ()-> new ResourceNotFoundException(id));
	}

	public Devedor inserirDevedor(Devedor obj) {

		return devedorRepositorios.save(obj);

	}
	
	
	public void delete(Long id) {
		
	devedorRepositorios.deleteById(id);
		
	}
	
	
	public Devedor atualizar(Long id, Devedor obj) {
		Devedor entity = devedorRepositorios.getReferenceById(id);
		atualizarDados(entity, obj);
		
		return devedorRepositorios.save(entity);
		
	}

	private void atualizarDados(Devedor entity, Devedor obj) {
		
		entity.setNome(obj.getNome());
		//entity.setDevedorStatus(obj.getDevedorStatus());
		//entity.setdescricao(obj.getdescricao());
		//entity.setDataRegistro(obj.getDataRegistro());
	}
	

}
