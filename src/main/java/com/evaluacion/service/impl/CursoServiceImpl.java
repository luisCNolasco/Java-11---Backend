package com.evaluacion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.model.Curso;
import com.evaluacion.repo.ICursoRepo;
import com.evaluacion.repo.IGenericRepo;
import com.evaluacion.service.ICursoService;

@Service
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService{

	@Autowired
	private ICursoRepo repo;
	
	@Override
	protected IGenericRepo<Curso, Integer> getRepo() {
		return repo;
	}

}
