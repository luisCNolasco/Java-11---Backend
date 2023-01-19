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

import com.evaluacion.dto.EstudianteDTO;
import com.evaluacion.exception.ModelNotFoundException;
import com.evaluacion.model.Estudiante;
import com.evaluacion.service.IEstudianteService;

@RestController
@RequestMapping("estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception {
		List<EstudianteDTO> list = service.listar().stream().map(est -> mapper.map(est, EstudianteDTO.class))
				.collect(Collectors.toList());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstudianteDTO> readById(@PathVariable("id") Integer id) throws Exception {
		EstudianteDTO obj = mapper.map(service.obtener(id), EstudianteDTO.class);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EstudianteDTO> create(@Valid @RequestBody EstudianteDTO dto) throws Exception {
		Estudiante obj = service.registrar(mapper.map(dto, Estudiante.class));
		return new ResponseEntity<>(mapper.map(obj, EstudianteDTO.class), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody EstudianteDTO dto) throws Exception {
		Estudiante obj = service.actualizar(mapper.map(dto, Estudiante.class));
		return new ResponseEntity<>(mapper.map(obj, EstudianteDTO.class), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		Estudiante obj = service.obtener(id);

		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/order")
	public ResponseEntity<List<EstudianteDTO>> readAllByAgeDesc() throws Exception {
		List<EstudianteDTO> list = service.listByAgeDesc().stream().map(est -> mapper.map(est, EstudianteDTO.class))
				.collect(Collectors.toList());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	

}
