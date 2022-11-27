package com.financeiro.Financeiro.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.Financeiro.data.vo.v1.ContaVO;
import com.financeiro.Financeiro.data.vo.v2.ContaVOV2;
import com.financeiro.Financeiro.entidades.Conta;
import com.financeiro.Financeiro.mapper.DozerMapper;
import com.financeiro.Financeiro.mapper.custom.ContaMapper;
import com.financeiro.Financeiro.repositorios.ContaRepositorios;
import com.financeiro.Financeiro.servicos.exception.ResourceNotFoundException;

@Service
public class ContaServicos {

	@Autowired
	private ContaRepositorios contaRepositorios;
	
	@Autowired
	private ContaMapper mapper;

	public List<ContaVO> procurarTodos() {

		return DozerMapper.parseListObjects(contaRepositorios.findAll(), ContaVO.class);
	}

	public ContaVO procurarPorId(Long id) {

		var entity = contaRepositorios.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));

		return DozerMapper.parseObject(entity, ContaVO.class);
	}

	public ContaVO inserirConta(ContaVO contaVO) {

		var entity = DozerMapper.parseObject(contaVO, Conta.class);
		var vo = DozerMapper.parseObject(contaRepositorios.save(entity), ContaVO.class);
		
		return vo;

	}
	
	public ContaVOV2 inserirContav2(ContaVOV2 contaVOV2) {

		var entity = mapper.convertoEntity(contaVOV2);
		var vo = mapper.convertEntityToVo(contaRepositorios.save(entity));
		
		return vo;

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
		// entity.setContaStatus(obj.getContaStatus());
		// entity.setdescricao(obj.getdescricao());
		// entity.setDataRegistro(obj.getDataRegistro());
	}

}
