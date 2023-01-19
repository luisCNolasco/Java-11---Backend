package com.evaluacion.service;

import java.util.List;

import com.evaluacion.model.Estudiante;

public interface IEstudianteService extends ICRUD<Estudiante, Integer>{

	List<Estudiante> listByAgeDesc();
}
