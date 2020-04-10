package com.jeffersonguanabara.dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jeffersonguanabara.dev.domain.Produto;
import com.jeffersonguanabara.dev.repository.ProdutoRepository;
import com.jeffersonguanabara.dev.service.dto.ProdutoDTO;
import com.jeffersonguanabara.dev.service.dto.ProdutosIdNomeLocalFabricacaoDTO;
import com.jeffersonguanabara.dev.service.dto.ProdutosNomeMarcaVencimentoDTO;

@Service
public class ProdutoService implements CrudService<Produto>{

	@Autowired
	private ProdutoRepository produtorepository;
	
	@Override
	public Produto save(Produto produto) {
		return produtorepository.save(produto);
	}

	@Override
	public Produto update(Produto produto) {
		if (produto.getId() == null)
			throw new NoSuchElementException();
		return produtorepository.save(produto);
	}

	@Override
	public List<Produto> getObjects() {
		return produtorepository.findAll();
	}

	@Override
	public Produto getObjectById(int id) {
		return produtorepository.findById(id).get();
	}

	@Override
	public ResponseEntity<Produto> deleteById(int id) {
		produtorepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	public List<ProdutosNomeMarcaVencimentoDTO> buscarPorAnoDeFabricacao(int ano) {
		List<Produto> produtos = produtorepository.findProdutosAnoFabricacao(ano);
		List<ProdutosNomeMarcaVencimentoDTO> produtosDTO = new ArrayList<>();
		for (Produto produto : produtos) {
			produtosDTO.add(new ProdutosNomeMarcaVencimentoDTO(produto));
		}
		return produtosDTO;
	}
	
	public List<Produto> buscaEntreDeVencimento(LocalDate date1, LocalDate date2) {
		return produtorepository.findProdutosBetweenDiasVencimento(date1, date2);
	}

	public List<Produto> buscarProdutosVencidos(LocalDate date) {
		return produtorepository.findProdutosVencidos(date);
	}
	
	public List<ProdutosIdNomeLocalFabricacaoDTO> buscarProdutosPorMarcaAndAnoFabricacao(String marca, int anoFabricacao) {
		List<Produto> produtos = produtorepository.findProdutosMarcaAndAnoFabricao(marca, anoFabricacao);
		List<ProdutosIdNomeLocalFabricacaoDTO> produtosDTO = new ArrayList<>();
		for (Produto produto : produtos) {
			produtosDTO.add(new ProdutosIdNomeLocalFabricacaoDTO(produto));
		}
		return produtosDTO;
	}
	
	public ProdutoDTO buscarProdutoPorCodigoDeBarras(String codigoBarras) throws NullPointerException{
		try {
			System.out.println(codigoBarras);
			Produto produto = produtorepository.findProdutoByCodigoBarras(codigoBarras);  
			return new ProdutoDTO(produto);
		} catch (Exception e) {
			throw new NullPointerException("Nenhum produto foi encontrado!");
		}
		
	}
}
