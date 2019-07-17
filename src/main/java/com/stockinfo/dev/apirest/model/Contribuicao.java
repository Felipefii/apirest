package com.stockinfo.dev.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contribuicao {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private float valor;
	@Enumerated(EnumType.STRING)
	private TipoContribuicao tipoContribuicao;
	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public TipoContribuicao getTipoContribuicao() {
		return tipoContribuicao;
	}
	public void setTipoContribuicao(TipoContribuicao tipoContribuicao) {
		this.tipoContribuicao = tipoContribuicao;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}
