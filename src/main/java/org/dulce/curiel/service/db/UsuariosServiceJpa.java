package org.dulce.curiel.service.db;

import java.util.List;
import java.util.Optional;

import org.dulce.curiel.model.Usuario;
import org.dulce.curiel.repository.UsuarioRepository;
import org.dulce.curiel.service.IntUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UsuariosServiceJpa implements IntUsuariosService{
	
	@Autowired
	private UsuarioRepository repoUsuarios;

	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll();
	}

	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		repoUsuarios.save(usuario);		
	}

	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		repoUsuarios.deleteById(idUsuario);
	}

	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional= repoUsuarios.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
