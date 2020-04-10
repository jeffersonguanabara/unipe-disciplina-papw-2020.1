package com.jeffersonguanabara.dev.service.dto;

import com.jeffersonguanabara.dev.domain.Produto;

public class ProdutosIdNomeLocalFabricacaoDTO {

	private Integer Id;
	private String nome;
	private String localFabricacao;
	
	public ProdutosIdNomeLocalFabricacaoDTO(Produto produto) {
		setId(produto.getId());
		setNome(produto.getNome());
		setLocalFabricacao(produto.getLocalFabricacao());
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalFabricacao() {
		return localFabricacao;
	}
	public void setLocalFabricacao(String localFabricacao) {
		this.localFabricacao = localFabricacao;
	}
}
