package com.stockinfo.dev.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockinfo.dev.apirest.model.Conta;

public interface RepositorioConta extends JpaRepository<Conta, Long>{
	
	
}
