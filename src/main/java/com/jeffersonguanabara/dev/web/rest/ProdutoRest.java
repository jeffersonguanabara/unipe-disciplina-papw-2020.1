package com.jeffersonguanabara.dev.web.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonguanabara.dev.domain.Produto;
import com.jeffersonguanabara.dev.service.ProdutoService;
import com.jeffersonguanabara.dev.service.dto.ProdutoDTO;
import com.jeffersonguanabara.dev.service.dto.ProdutosIdNomeLocalFabricacaoDTO;
import com.jeffersonguanabara.dev.service.dto.ProdutosNomeMarcaVencimentoDTO;

@RestController
@RequestMapping("/api")
public class ProdutoRest {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> save(@RequestBody @Validated Produto produto) {
		return ResponseEntity.ok(produtoService.save(produto));
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> getProdutos() {
		return ResponseEntity.ok(produtoService.getObjects());		
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> findById(@PathVariable int id) {
		return ResponseEntity.ok(produtoService.getObjectById(id));
	}
	
	@PutMapping("/produto")
	public ResponseEntity<Produto> update(@RequestBody @Validated Produto produto) {
		return ResponseEntity.ok(produtoService.update(produto));
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Produto> deleteProdutoById(@PathVariable Integer id) {
		return produtoService.deleteById(id);
	}
	
	@GetMapping("/produto/ano/{anoFabricacao}")
	public ResponseEntity<List<ProdutosNomeMarcaVencimentoDTO>> findByAnoFabricacao(@PathVariable int anoFabricacao) {
		return ResponseEntity.ok().body(produtoService.buscarPorAnoDeFabricacao(anoFabricacao));
	}
	
	@PostMapping("/produto/dataOne/dataTwo")
	public ResponseEntity<List<Produto>> findByVencimentos(@RequestBody @Validated LocalDate dataOne, LocalDate dataTwo) {
		System.out.println(dataOne + ", " + dataTwo);
		return ResponseEntity.ok(produtoService.buscaEntreDeVencimento(dataOne, dataTwo));
	}
	
	@PostMapping("/produto/dataVencimento")
	public ResponseEntity<List<Produto>> findByVencidos(@RequestBody @Validated LocalDate dataVencimento) {
		return ResponseEntity.ok().body(produtoService.buscarProdutosVencidos(dataVencimento));
	}
	
	@PostMapping("produto/marca/anoFabricacao")
	public ResponseEntity<List<ProdutosIdNomeLocalFabricacaoDTO>> findByMarcaAndAnoFabricacao(@RequestBody @Validated String marca, int anoFabricacao) {
		return ResponseEntity.ok(produtoService.buscarProdutosPorMarcaAndAnoFabricacao(marca, anoFabricacao));
	}
	
	@GetMapping("produto/codigoBarras/{codigoBarras}")
	public ResponseEntity<ProdutoDTO> findProductByCodeBar(@PathVariable @Validated String codigoBarras) {
		return ResponseEntity.ok().body(produtoService.buscarProdutoPorCodigoDeBarras(codigoBarras));
	}
}
