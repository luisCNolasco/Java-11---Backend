package com.evaluacion.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

public class DetalleMatriculaDTO {


	@NotNull
	@JsonIncludeProperties({"idCurso","nombre"})
	private CursoDTO curso;

	@NotNull
	@NotEmpty
	private String aula;

	@JsonBackReference
	private RegistrarMatriculaDTO registrarMatricula;

	public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public RegistrarMatriculaDTO getRegistrarMatricula() {
		return registrarMatricula;
	}

	public void setRegistrarMatricula(RegistrarMatriculaDTO registrarMatricula) {
		this.registrarMatricula = registrarMatricula;
	}
	
	
}
