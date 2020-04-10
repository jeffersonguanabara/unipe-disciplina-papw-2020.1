package com.jeffersonguanabara.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeffersonguanabara.dev.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

	List<Disciplina> findDisciplinaByProfessor(String professor);
	
	List<Disciplina> findDisciplinaByNomeAndProfessor(String nome, String professor);
}
