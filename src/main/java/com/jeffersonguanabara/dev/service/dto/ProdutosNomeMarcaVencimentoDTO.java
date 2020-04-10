package com.jeffersonguanabara.dev.service.dto;

import java.time.LocalDate;

import com.jeffersonguanabara.dev.domain.Produto;

public class ProdutosNomeMarcaVencimentoDTO {

	private String nome;
	private String marca;
	private LocalDate dataVencimento;
		
	public ProdutosNomeMarcaVencimentoDTO(Produto produto) {
		setNome(produto.getNome());
		setMarca(produto.getMarca());
		setDataVencimento(produto.getDataVencimento());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
