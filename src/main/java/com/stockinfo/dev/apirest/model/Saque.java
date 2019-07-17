package com.stockinfo.dev.apirest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Saque {
	
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
	@Enumerated(EnumType.STRING)
	private StatusSaque status;
	@Column
	private int qtdeParcelas;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataTransacao;
	
	
	public Date getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	public StatusSaque getStatus() {
		return status;
	}
	public void setStatus(StatusSaque status) {
		this.status = status;
	}
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
