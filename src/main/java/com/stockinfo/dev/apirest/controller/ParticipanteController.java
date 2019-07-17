package com.stockinfo.dev.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockinfo.dev.apirest.model.Conta;
import com.stockinfo.dev.apirest.model.Contribuicao;
import com.stockinfo.dev.apirest.model.Participante;
import com.stockinfo.dev.apirest.model.Saque;
import com.stockinfo.dev.apirest.repository.RepositorioConta;
import com.stockinfo.dev.apirest.repository.RepositorioContribuicao;
import com.stockinfo.dev.apirest.repository.RepositorioParticipante;
import com.stockinfo.dev.apirest.repository.RepositorioSaque;
import com.stockinfo.dev.apirest.util.Datas;

@RestController
@RequestMapping("/participante")
@CrossOrigin
public class ParticipanteController {
	
	@Autowired
	private RepositorioParticipante repositorioParticipante;
	@Autowired
	private RepositorioConta repositorioConta;
	@Autowired
	private RepositorioContribuicao repositorioContribuicao;
	@Autowired
	private RepositorioSaque repositorioSaque;
	
	
	@GetMapping("/participantes")
	public List<Participante> participantes() {
		
		return repositorioParticipante.findAll();
	}
	
	@GetMapping("/participante/{id}")
	public Participante participante(@PathVariable(value="id") Long id) {
		
		return repositorioParticipante.findOne(id);
	}
	
	@PostMapping("/inserir")
	public Participante inserirParticipante(@RequestBody Participante participante) {
		Conta conta = new Conta ();
		repositorioConta.save(conta);
		participante.setConta(conta);
		return repositorioParticipante.save(participante);
	}
	
	@PutMapping("/atualizar")
	public Participante atualizaParticipante(@RequestBody Participante participante) {
		
		repositorioConta.save(participante.getConta());
		return repositorioParticipante.save(participante);
	}
	
	@PostMapping("/{id}/contribuicao")
	public Contribuicao contribuir(@PathVariable Long id, @RequestBody Contribuicao contribuicao) {
		
		Participante participante;
		participante = repositorioParticipante.findOne(id);
		contribuicao.setConta(participante.getConta());
		
		return repositorioContribuicao.save(contribuicao);
	}
	
	@GetMapping("/{id}/contribuicoes")
	public List<Contribuicao> buscarContribuicoes(@PathVariable Long id){
		Conta conta = repositorioConta.findOne(id);
		return repositorioContribuicao.findByConta(conta);
	}
	@GetMapping("{id}/saldo")
	public Float saldo(@PathVariable Long id) {
		
		return repositorioContribuicao.findSaldoByConta(id);
	}
	
	@GetMapping("/{id}/saldotipo")
	public Float saldoTipoContribuicao(@PathVariable Long id,  @RequestBody Saque saque) {
		Participante participante = repositorioParticipante.findOne(id);		
		
		float saldoContribuicoes = 
				repositorioContribuicao.findSaldoByTipoContribuicao(saque.getTipoContribuicao().name(),
						participante.getConta().getId());
		
		return saldoContribuicoes;
	}
	
	@PostMapping("/{id}/saque")
	public Saque realizarSaque(@PathVariable Long id, @RequestBody Saque saque) {
		Participante participante = repositorioParticipante.findOne(id);
		
		Datas datas = new Datas();
		int dif = datas.difMeses(participante);
		System.out.println(dif);
		if(dif >= 31) {
			float saldoPositivo;
			float saldoNegativo; 
			if(repositorioContribuicao.findNumRowsContribuicao(participante.getConta().getId()) > 0) {
				saldoPositivo = repositorioContribuicao.findSaldoByTipoContribuicao(saque.getTipoContribuicao().name(),
						participante.getConta().getId());
				System.out.println(saldoPositivo);
			}else {
				saldoPositivo = 0;
			}
			
			if(repositorioSaque.findNumRowsSaque(participante.getConta().getId()) > 0) {
				saldoNegativo = repositorioSaque.findSaldoByTipoContribuicao(saque.getTipoContribuicao().name(),
						participante.getConta().getId());
				System.out.println(saldoNegativo);
			}else {
				saldoNegativo = 0;
			}
			
			float saldo = saldoPositivo - saldoNegativo;
			
			if(saldo > saque.getValor()) {
				saque.setConta(participante.getConta());
				repositorioSaque.save(saque);
			}else {
				if(saldo == saque.getValor()) {
					participante.getConta().setSituacao("INATIVO");
					repositorioParticipante.save(participante);
					saque.setConta(participante.getConta());
					repositorioSaque.save(saque);
				}
			}
		}		
		
		
		return saque;
	}
	
}
