package org.dulce.curiel.controller;

import java.util.List;

import org.dulce.curiel.model.Usuario;
import org.dulce.curiel.service.IntUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@PostMapping("/guardar")
	public String guardar(Usuario usuario) {
		usuario.setEstatus(0);
		usuariosService.guardar(usuario);
		return "formLogin";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista = usuariosService.obtenerTodas();
		for(Usuario u : lista) {
			System.out.println(u);
		}
		model.addAttribute("usuarios", lista);
		return "usuarios/listaUsuarios";
	}
	
	@GetMapping("/crear")
	public String crear() {
		return "usuarios/formRegistro";
	}
	
	@GetMapping("login")
	public String login() {
		return "formLogin";
	}
	
	
}
