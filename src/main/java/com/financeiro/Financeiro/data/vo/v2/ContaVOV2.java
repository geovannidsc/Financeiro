package com.financeiro.Financeiro.data.vo.v2;

import java.io.Serializable;
import java.util.Objects;

import com.financeiro.Financeiro.entidades.Categoria;
import com.financeiro.Financeiro.entidades.Devedor;
import com.financeiro.Financeiro.entidades.enums.ContaStatus;

public class ContaVOV2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descricao;
	private int contaStatus;
	//private Instant dataRegistro;
	private Categoria categoria;
	private Devedor devedor;
	private String prioridade;

	public ContaVOV2() {

	}

	public ContaVOV2(Long id, String nome, String descricao, Categoria categoria,
			ContaStatus contaStatus) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		//this.dataRegistro = dtRegistro;
		this.categoria = categoria;
		setContaStatus(contaStatus);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getdescricao() {
		return descricao;
	}

	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}



	public ContaStatus getContaStatus() {
		return ContaStatus.valor(contaStatus);
	}

	public void setContaStatus(ContaStatus contaStatus) {

		if (contaStatus != null) {

			this.contaStatus = contaStatus.getCode();

		}

	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Devedor getDevedor() {
		return devedor;
	}

	public void setDevedor(Devedor devedor) {
		this.devedor = devedor;
	}

	
	
	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaVOV2 other = (ContaVOV2) obj;
		return Objects.equals(id, other.id);
	}

}