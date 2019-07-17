package com.stockinfo.dev.apirest.model;

public enum TipoContribuicao {
	
	ADICIONAIS("contribuições adicionais"),
	NORMAIS("contribuições normais"),
	PORTABILIDADE("contribuições por portabilidade");
	
	private final String descricao;
	
	private TipoContribuicao(String descricao) {
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
