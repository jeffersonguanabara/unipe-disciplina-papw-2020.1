package com.jeffersonguanabara.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonguanabara.dev.domain.Disciplina;
import com.jeffersonguanabara.dev.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public List<Disciplina> getDisciplinaByNomeAndProfessor(String nome, String professor) {
		return disciplinaRepository.findDisciplinaByNomeAndProfessor(nome, professor);
	}
	
	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public Disciplina consultaPorId(Long id) {
		return disciplinaRepository.findById(id).get();
	}
	
	public void deletePorId(Long id) {
		disciplinaRepository.deleteById(id);
	}
	
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
	
	public Disciplina update(Disciplina disciplina) {
		if (disciplina != null)
			return disciplinaRepository.save(disciplina);
		throw new RuntimeException("Id precisa ser informado");
	}
}
