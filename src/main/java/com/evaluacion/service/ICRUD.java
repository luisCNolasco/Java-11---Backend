package com.evaluacion.service;

import java.util.List;

public interface ICRUD<T, ID> {

	T registrar(T t) throws Exception;

	T actualizar(T t) throws Exception;

	List<T> listar() throws Exception;

	T obtener(ID id) throws Exception;

	void eliminar(ID id) throws Exception;
}
