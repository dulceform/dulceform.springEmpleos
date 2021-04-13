package org.dulce.curiel.service;

import java.util.List;

import org.dulce.curiel.model.Usuario;

public interface IntUsuariosService {
	
	public List<Usuario> obtenerTodas();
	public void guardar(Usuario usuario);
	public void eliminar(Integer idUsuario);
	public Usuario buscarPorId(Integer idUsuario);

}
