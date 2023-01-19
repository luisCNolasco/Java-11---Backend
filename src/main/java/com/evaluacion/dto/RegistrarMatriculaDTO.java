package com.evaluacion.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrarMatriculaDTO {

	private Integer idRegistrarMatricula;

	@NotNull
	private LocalDateTime fechaMatricula = LocalDateTime.now();

	@NotNull
	@JsonIncludeProperties({ "idEstudiante", "dni" })
	private EstudianteDTO estudiante;

	@NotNull
	@JsonManagedReference
	private List<DetalleMatriculaDTO> detalle;

	@NotNull
	private boolean estado;

	public Integer getIdRegistrarMatricula() {
		return idRegistrarMatricula;
	}

	public void setIdRegistrarMatricula(Integer idRegistrarMatricula) {
		this.idRegistrarMatricula = idRegistrarMatricula;
	}

	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public EstudianteDTO getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteDTO estudiante) {
		this.estudiante = estudiante;
	}

	public List<DetalleMatriculaDTO> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleMatriculaDTO> detalle) {
		this.detalle = detalle;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
