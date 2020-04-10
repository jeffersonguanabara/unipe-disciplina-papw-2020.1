package com.jeffersonguanabara.dev.web.rest;

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

import com.jeffersonguanabara.dev.domain.Disciplina;
import com.jeffersonguanabara.dev.service.DisciplinaService;

@RestController
@RequestMapping("/api")
public class DisciplinaRest {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@PostMapping("/disciplina")
	public ResponseEntity<Disciplina> salvar(@RequestBody @Validated Disciplina disciplina) {
		return ResponseEntity.ok(disciplinaService.salvar(disciplina));
	}
	
	@PutMapping("/disciplina")
	public ResponseEntity<Disciplina> update(@RequestBody @Validated Disciplina disciplina) {
		return ResponseEntity.ok(disciplinaService.update(disciplina));
	}
	
	@GetMapping("/disciplina/{id}")
	public ResponseEntity<Disciplina> consultarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(disciplinaService.consultaPorId(id));
	}
	
	@GetMapping("/disciplina")
	public ResponseEntity<List<Disciplina>> listar() {
		return ResponseEntity.ok().body(disciplinaService.listar());
	}

	@DeleteMapping("/disciplina/{id}")
	public ResponseEntity deletePorId(@PathVariable Long id) {
		try {
			disciplinaService.deletePorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
