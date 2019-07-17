package com.stockinfo.dev.apirest.model;

public enum StatusSaque {
	
	ATIVO("contribuições adicionais"),
	INATIVO("contribuições normais");

	
	private final String descricao;
	
	private StatusSaque(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}
}
