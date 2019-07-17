package com.stockinfo.dev.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stockinfo.dev.apirest.model.Saque;

public interface RepositorioSaque extends JpaRepository<Saque, Long>{

	@Query(nativeQuery = true, 
			value = "select sum(s.valor) from conta cont "
					+ "join saque s "
					+ "on cont.id = s.id_conta "
					+ "where s.tipo_contribuicao = :tipoconta "
					+ "and cont.id = :conta")	
	public Float findSaldoByTipoContribuicao(@Param("tipoconta") String tipoConta, @Param("conta") Long conta);
	
	@Query(nativeQuery = true, value = "select count(id) from saque where id_conta = :id_conta ")	
	public Float findNumRowsSaque(@Param("id_conta") Long id_conta);
	
	
	
	
}
