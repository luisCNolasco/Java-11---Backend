package com.evaluacion.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.dto.CursoDTO;
import com.evaluacion.exception.ModelNotFoundException;
import com.evaluacion.model.Curso;
import com.evaluacion.service.ICursoService;

@RestController
@RequestMapping("cursos")
public class CursoController {

	@Autowired
	private ICursoService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<CursoDTO>> readAll() throws Exception {
		
		List<CursoDTO> list = service.listar().stream().map(cur -> mapper.map(cur, CursoDTO.class))
				.collect(Collectors.toList());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CursoDTO> readById(@PathVariable("id") Integer id) throws Exception {
		CursoDTO obj = mapper.map(service.obtener(id), CursoDTO.class);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CursoDTO> create(@Valid @RequestBody CursoDTO dto) throws Exception {
		
		Curso obj = service.registrar(mapper.map(dto, Curso.class));
		return new ResponseEntity<>(mapper.map(obj, CursoDTO.class), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoDTO dto) throws Exception {
		Curso obj = service.actualizar(mapper.map(dto, Curso.class));
		return new ResponseEntity<>(mapper.map(obj, CursoDTO.class), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		Curso obj = service.obtener(id);

		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
