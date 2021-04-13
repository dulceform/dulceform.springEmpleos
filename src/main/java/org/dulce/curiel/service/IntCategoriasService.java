package org.dulce.curiel.service;

import java.util.List;
import org.dulce.curiel.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface IntCategoriasService {
	//metodos abstractos
	public List<Categoria> obtenerTodas();
	public Categoria buscarPorId(Integer categoria);
	public void guardar(Categoria categoria);
	public void eliminar(Integer idCategoria);
	public Page<Categoria> buscarTodas(Pageable page);
}
