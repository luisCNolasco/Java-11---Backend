package com.evaluacion.service;


import java.util.List;
import java.util.Map;

import com.evaluacion.model.DetalleMatricula;
import com.evaluacion.model.RegistrarMatricula;

public interface IRegistrarMatriculaService extends ICRUD<RegistrarMatricula, Integer>{

	List<Map<String, List<String>>> listarAlumnosPorCurso();
}
