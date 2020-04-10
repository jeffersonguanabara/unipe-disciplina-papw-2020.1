package com.jeffersonguanabara.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeffersonguanabara.dev.domain.Quarentena;

public interface QuarentenaRepository extends JpaRepository<Quarentena, Long>{

	public List<Quarentena> findQuarentenaByUf(String uf);
	
	public List<Quarentena> findQuarentenaByNomePessoaAndUf(String nomePessoa, String uf);
}
