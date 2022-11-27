package com.financeiro.Financeiro.mapper.custom;

import org.springframework.stereotype.Service;

import com.financeiro.Financeiro.data.vo.v2.ContaVOV2;
import com.financeiro.Financeiro.entidades.Conta;

@Service
public class ContaMapper {

	public ContaVOV2 convertEntityToVo(Conta conta) {

		ContaVOV2 vo = new ContaVOV2();
		vo.setId(conta.getId());
		vo.setNome(conta.getNome());
		vo.setdescricao(conta.getdescricao());
		//vo.setDataRegistro(conta.getDataRegistro());
		vo.setDevedor(conta.getDevedor());
		// vo.setPrioridade(conta.g);
		vo.setCategoria(conta.getCategoria());
		vo.setContaStatus(conta.getContaStatus());

		return vo;
	}

	public Conta convertoEntity(ContaVOV2 contaVOV2) {

		Conta conta = new Conta();
		conta.setId(conta.getId());
		conta.setNome(contaVOV2.getNome());
		conta.setdescricao(contaVOV2.getdescricao());
		//conta.setDataRegistro(contaVOV2.getDataRegistro());
		conta.setDevedor(contaVOV2.getDevedor());
		// vo.setPrioridade(conta.g);
		conta.setCategoria(contaVOV2.getCategoria());
		conta.setContaStatus(contaVOV2.getContaStatus());

		return conta;
	}

}
