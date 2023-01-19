package com.evaluacion.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.model.Estudiante;
import com.evaluacion.repo.IEstudianteRepo;
import com.evaluacion.repo.IGenericRepo;
import com.evaluacion.service.IEstudianteService;

@Service
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

	@Autowired
	private IEstudianteRepo repo;

	@Override
	protected IGenericRepo<Estudiante, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Estudiante> listByAgeDesc() {

		return repo.findAll().stream().sorted(Comparator.comparing(Estudiante::getEdad).reversed())
				.collect(Collectors.toList());

	}

}
