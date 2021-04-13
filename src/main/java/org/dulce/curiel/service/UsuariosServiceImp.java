package org.dulce.curiel.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.dulce.curiel.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImp implements IntUsuariosService {
	
	private List<Usuario> lista = null;
	
	public UsuariosServiceImp() {
		lista = new LinkedList<Usuario>();
		try {
			Usuario u1 = new Usuario();
			u1.setId(1);
			u1.setNombre("Marcos");
			u1.setEmail("marcosG@gmail.com");
			u1.setUsername("Marcos01");
			u1.setPassword("123456");
			u1.setEstatus(0);
			u1.setFechaRegistro(LocalDate.parse("02-02-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			lista.add(u1);
			
			Usuario u2 = new Usuario();
			u2.setId(2);
			u2.setNombre("Celeste");
			u2.setEmail("celesteOP@gmail.com");
			u2.setUsername("cel89");
			u2.setPassword("654321");
			u2.setEstatus(0);
			u2.setFechaRegistro(LocalDate.parse("08-02-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			lista.add(u2);
			
			Usuario u3 = new Usuario();
			u3.setId(3);
			u3.setNombre("Roosevelt");
			u3.setEmail("jovanyM@gmail.com");
			u3.setUsername("roos43");
			u3.setPassword("78998");
			u1.setEstatus(1);
			u3.setFechaRegistro(LocalDate.parse("13-02-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			lista.add(u3);
		}catch(DateTimeParseException ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}

	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		for(Usuario usuario : lista) {
			if(usuario.getId() == idUsuario) {
				return usuario;
			}
		}
		return null;
	}

	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		
	}

}
