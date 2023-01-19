package com.evaluacion.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RegistrarMatricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistrarMatricula;

	@Column(nullable = false)
	private LocalDateTime fechaMatricula = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "idEstudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_RegistrarMatricula_Estudiante"))
	private Estudiante estudiante;

	@OneToMany(mappedBy = "registrarMatricula", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<DetalleMatricula> detalle;

	@Column(nullable = false)
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<DetalleMatricula> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleMatricula> detalle) {
		this.detalle = detalle;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
