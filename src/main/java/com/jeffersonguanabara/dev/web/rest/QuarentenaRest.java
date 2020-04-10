package com.jeffersonguanabara.dev.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonguanabara.dev.domain.Quarentena;
import com.jeffersonguanabara.dev.service.QuarentenaService;
import com.jeffersonguanabara.dev.service.dto.QuarentenaNomeCidadeDTO;

@RestController
@RequestMapping("/api")
public class QuarentenaRest {

	@Autowired
	private QuarentenaService quarentenaService;
	
	@GetMapping("/quarentena/{estado}")
	public ResponseEntity<List<Quarentena>> getQuarentenaPorUf(@PathVariable String estado) {
		return ResponseEntity.ok().body(quarentenaService.getQuarentenaByUf(estado));
	}
	
	@PostMapping("quarentena")
	public ResponseEntity<Quarentena> salvar(@RequestBody @Validated Quarentena quarentena) {
		Quarentena quarentenaSalva = quarentenaService.salvar(quarentena);
		return ResponseEntity.ok().body(quarentenaSalva);
	}
	
	@GetMapping("/quarentena")
	public ResponseEntity<List<Quarentena>> getQuarentena() {
		return ResponseEntity.ok(quarentenaService.getQuarentena());
	}
	
	@GetMapping("/quarentena/{id}")
	public ResponseEntity<Quarentena> getQuarentenaPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(quarentenaService.getQuarentenaById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/quarentena/nome/cidade/{id")
	public ResponseEntity<QuarentenaNomeCidadeDTO> getQuarentenaNomeCidadeById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(quarentenaService.getQuarentenaNomeCidadeById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/quarentena/{id}")
	public ResponseEntity deleteBYin(@PathVariable Long id) {
		try {
			quarentenaService.deleteQuarentenaById(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
