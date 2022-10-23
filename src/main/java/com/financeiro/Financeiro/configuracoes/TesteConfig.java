package com.financeiro.Financeiro.configuracoes;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.financeiro.Financeiro.entidades.Categoria;
import com.financeiro.Financeiro.entidades.Conta;
import com.financeiro.Financeiro.entidades.enums.ContaStatus;
import com.financeiro.Financeiro.repositorios.CategoriaRepositorios;
import com.financeiro.Financeiro.repositorios.ContaRepositorios;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private ContaRepositorios contaRepositorios;

	@Autowired
	private CategoriaRepositorios categoriaRepositorios;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria ca1 = new Categoria(null, "Fixas");
		Categoria ca2 = new Categoria(null, "Variaveis");
		
		
		Conta c1 = new Conta(null, "Equatorial","Energia",Instant.parse("2019-06-20T19:53:07Z"), ca1,ContaStatus.A_PAGAR );
		Conta c2 = new Conta(null, "BRK","Agua", Instant.parse("2020-07-20T19:53:07Z"),ca2, ContaStatus.PAGO);
		categoriaRepositorios.saveAll(Arrays.asList(ca1,ca2));
		contaRepositorios.saveAll(Arrays.asList(c1,c2));
		
		
	
	}
	
	
	
	
}
