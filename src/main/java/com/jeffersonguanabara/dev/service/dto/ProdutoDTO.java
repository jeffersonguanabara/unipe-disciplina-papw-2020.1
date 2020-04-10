package com.jeffersonguanabara.dev.service.dto;

import java.time.LocalDate;

import com.jeffersonguanabara.dev.domain.Produto;

public class ProdutoDTO {

	private String nome;
	private String marca;
	private String codigoBarras;
	private LocalDate dataVencimento;
	
	public ProdutoDTO(Produto produto) {
		setNome(produto.getNome());
		setMarca(produto.getMarca());
		setCodigoBarras(produto.getCodigoBarras());
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
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
