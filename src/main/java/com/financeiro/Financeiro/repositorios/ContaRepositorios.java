package com.financeiro.Financeiro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.Financeiro.entidades.Conta;

public interface ContaRepositorios extends JpaRepository<Conta, Long> {
	
	
}
