package com.evaluacion.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.model.DetalleMatricula;
import com.evaluacion.model.RegistrarMatricula;
import com.evaluacion.repo.IGenericRepo;
import com.evaluacion.repo.IRegistrarMatriculaRepo;
import com.evaluacion.service.IRegistrarMatriculaService;

@Service
public class RegitrarMatriculaServiceImpl extends CRUDImpl<RegistrarMatricula, Integer>
		implements IRegistrarMatriculaService {

	@Autowired
	private IRegistrarMatriculaRepo repo;

	@Override
	protected IGenericRepo<RegistrarMatricula, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Map<String, List<String>>> listarAlumnosPorCurso() {

		Stream<List<DetalleMatricula>> stream = repo.findAll().stream().map(RegistrarMatricula::getDetalle);

		Stream<DetalleMatricula> streamDetail = stream.flatMap(Collection::stream);

		Map<String, List<DetalleMatricula>> agrupados = streamDetail
				.collect(Collectors.groupingBy(e -> e.getCurso().getNombre()));

		List<Map<String, List<String>>> resultados = new ArrayList<>();

		agrupados.entrySet().forEach(d -> {

			Map<String, List<String>> obj = new HashMap<>();
			List<String> nombres = new ArrayList<>();

			d.getValue().forEach(f -> {
				nombres.add(f.getRegistrarMatricula().getEstudiante().getNombres());
			});
			obj.put(d.getKey(), nombres);

			resultados.add(obj);
		});

		return resultados;
	}

}
