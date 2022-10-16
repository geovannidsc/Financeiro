package com.financeiro.Financeiro.configuracoes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.financeiro.Financeiro.entidades.Conta;
import com.financeiro.Financeiro.repositorios.ContaRepositorios;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private ContaRepositorios contaRepositorios;

	@Override
	public void run(String... args) throws Exception {
		Conta c1 = new Conta(null, "Equatorial","Energia");
		Conta c2 = new Conta(null, "BRK","Agua");
		
		contaRepositorios.saveAll(Arrays.asList(c1,c2));
	}
	
	
	
	
}
