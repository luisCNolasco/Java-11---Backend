package com.evaluacion.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {

	@Min(value = 1)
	private Integer idEstudiante;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombres;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String apellidos;

	@NotNull
	@NotEmpty
	@Size(min = 8, max = 8)
	private String dni;

	@NotNull
	private int edad;

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
