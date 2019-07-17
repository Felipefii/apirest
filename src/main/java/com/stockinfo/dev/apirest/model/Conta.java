package com.stockinfo.dev.apirest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private Float saldoPort;
	@Column
	private Float saldoContAdi;
	@Column
	private Float saldoContNor;
	@Column
	private String situacao;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataInscricao;
	
	
	public Conta() {
		super();
		this.saldoPort = (float) 0;
		this.saldoContAdi = (float) 0;
		this.saldoContNor = (float) 0;
		this.situacao = "Ativo";
		this.dataInscricao = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getSaldoPort() {
		return saldoPort;
	}
	public void setSaldoPort(Float saldoPort) {
		this.saldoPort = saldoPort;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getDataInscricao() {
		return dataInscricao;
	}
	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	public Float getSaldoContAdi() {
		return saldoContAdi;
	}
	public void setSaldoContAdi(Float saldoContAdi) {
		this.saldoContAdi = saldoContAdi;
	}
	public Float getSaldoContNor() {
		return saldoContNor;
	}
	public void setSaldoContNor(Float saldoContNor) {
		this.saldoContNor = saldoContNor;
	}
	
	
	
	
}
