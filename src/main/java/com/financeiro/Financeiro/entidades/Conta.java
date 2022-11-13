package com.financeiro.Financeiro.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.financeiro.Financeiro.entidades.enums.ContaStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;

	private Integer contaStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataRegistro;

	@ManyToOne
	@JoinColumn(name = "Categoria_Id")
	private Categoria categoria;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Devedor_Id")
	private Devedor devedor;

	public Conta() {

	}

	public Conta(Long id, String nome, String descricao, Instant dtRegistro, Categoria categoria,
			ContaStatus contaStatus) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataRegistro = dtRegistro;
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

	public Instant getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Instant dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public ContaStatus getContaStatus() {
		return ContaStatus.valor(contaStatus);
	}

	public void setContaStatus(ContaStatus contaStatus) {
		if(contaStatus!=null) {
		
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}

}
