package com.evaluacion.controller;

import java.util.List;
import java.util.Map;
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

import com.evaluacion.dto.RegistrarMatriculaDTO;
import com.evaluacion.exception.ModelNotFoundException;
import com.evaluacion.model.RegistrarMatricula;
import com.evaluacion.service.IRegistrarMatriculaService;

@RestController
@RequestMapping("matriculas")
public class MatriculaController {

	@Autowired
	private IRegistrarMatriculaService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<RegistrarMatriculaDTO>> readAll() throws Exception {
		
		List<RegistrarMatriculaDTO> list = service.listar().stream().map(cur -> mapper.map(cur, RegistrarMatriculaDTO.class))
				.collect(Collectors.toList());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistrarMatriculaDTO> readById(@PathVariable("id") Integer id) throws Exception {
		RegistrarMatriculaDTO obj = mapper.map(service.obtener(id), RegistrarMatriculaDTO.class);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<RegistrarMatriculaDTO> create(@Valid @RequestBody RegistrarMatriculaDTO dto) throws Exception {
		
		RegistrarMatricula obj = service.registrar(mapper.map(dto, RegistrarMatricula.class));
		return new ResponseEntity<>(mapper.map(obj, RegistrarMatriculaDTO.class), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<RegistrarMatriculaDTO> update(@Valid @RequestBody RegistrarMatriculaDTO dto) throws Exception {
		RegistrarMatricula obj = service.actualizar(mapper.map(dto, RegistrarMatricula.class));
		return new ResponseEntity<>(mapper.map(obj, RegistrarMatriculaDTO.class), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		RegistrarMatricula obj = service.obtener(id);

		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/consulta")
	public ResponseEntity<List<Map<String, List<String>>>> consuta() throws Exception {
		
		List<Map<String, List<String>>> list = service.listarAlumnosPorCurso();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}





