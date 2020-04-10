package com.jeffersonguanabara.dev.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeffersonguanabara.dev.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	@Query(
			value="SELECT * FROM produto p WHERE p.ano_Fabricacao = :ano",
			nativeQuery = true
			)
	public List<Produto> findProdutosAnoFabricacao(@Param("ano") int anoFabricacao);
	
	@Query(
			value="SELECT * FROM produto p WHERE p.data_Vencimento BETWEEN :dateOne AND :dateTwo",
			nativeQuery = true
			)
	public List<Produto> findProdutosBetweenDiasVencimento(@Param("dateOne") LocalDate dateOne, @Param("dateTwo") LocalDate dateTwo);
	
	@Query(
			value = "SELECT * FROM produto p WHERE p.data_Vencimento <= :date",
			nativeQuery = true
			)
	public List<Produto> findProdutosVencidos(@Param("date") LocalDate date);
	
	@Query(
			value = "SELECT * FROM produto p WHERE p.marca = :marca AND p.ano_Fabricacao = :anoFabricacao",
			nativeQuery = true
			)
	public List<Produto> findProdutosMarcaAndAnoFabricao(@Param("marca") String marca, @Param("anoFabricacao") int anoFabricacao);
	
	@Query(
			value = "SELECT * FROM produto p WHERE p.codigo_barras = :codigoBarras",
			nativeQuery = true
			)
	public Produto findProdutoByCodigoBarras(@Param("codigoBarras") String codigoBarras); 

}
