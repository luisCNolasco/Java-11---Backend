package com.evaluacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@Entity
public class DetalleMatricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleMatricula;

	@ManyToOne
	@JoinColumn(name = "idCurso", nullable = false)
	private Curso curso;

	@Column(length = 30, nullable = false)
	private String aula;

	@ManyToOne
	@JoinColumn(name = "idRegistrarMatricula", nullable = false)
	@JsonIncludeProperties({"idRegistrarMatricula","estudiante"})
	private RegistrarMatricula registrarMatricula;

	public Integer getIdDetalleMatricula() {
		return idDetalleMatricula;
	}

	public void setIdDetalleMatricula(Integer idDetalleMatricula) {
		this.idDetalleMatricula = idDetalleMatricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public RegistrarMatricula getRegistrarMatricula() {
		return registrarMatricula;
	}

	public void setRegistrarMatricula(RegistrarMatricula registrarMatricula) {
		this.registrarMatricula = registrarMatricula;
	}
	
	public Double getEntero() {
		return 1.2;
	}

}
