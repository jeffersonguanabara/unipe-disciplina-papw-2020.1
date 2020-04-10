package com.jeffersonguanabara.dev.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jeffersonguanabara.dev.domain.Produto;

public interface CrudService<T> {

	public T save(T t);
	public T update(T t);
	public List<T> getObjects();
	public Produto getObjectById(int id);
	public ResponseEntity<T> deleteById(int id);
	
}
