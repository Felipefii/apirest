package com.stockinfo.dev.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stockinfo.dev.apirest.model.Conta;
import com.stockinfo.dev.apirest.model.Contribuicao;

public interface RepositorioContribuicao extends JpaRepository<Contribuicao, Long>{
	
	public List<Contribuicao> findByConta(Conta conta);
	
	@Query(nativeQuery = true, 
			value = "select sum(contrib.valor) from conta cont "
					+ "join contribuicao contrib on cont.id = contrib.id_conta "					
					+ "where cont.id = :conta")	
	public Float findSaldoByConta(@Param("conta") Long conta);
	
	@Query(nativeQuery = true, 
			value = "select sum(contrib.valor) from conta cont "
					+ "join contribuicao contrib "
					+ "on cont.id = contrib.id_conta "
					+ "where contrib.tipo_contribuicao = :tipoconta "
					+ "and cont.id = :conta")	
	public Float findSaldoByTipoContribuicao(@Param("tipoconta") String tipoConta, @Param("conta") Long conta);
	
	@Query(nativeQuery = true, value = "select count(id) from contribuicao where id = :id_conta")	
	public Float findNumRowsContribuicao(@Param("id_conta") Long id_conta);
}
