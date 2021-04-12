package org.dulce.curiel.controller;

import java.util.List;

import org.dulce.curiel.model.Categoria;
import org.dulce.curiel.service.IntCategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	@Autowired
	private IntCategoriasService categoriaService;
	
	@RequestMapping(value="/modificar", method=RequestMethod.GET)
	public String modificar(@RequestParam("id")int idCategoria, Model model) {
		Categoria categoria = categoriaService.buscarPorId(idCategoria);
		model.addAttribute("categoria" ,categoria);
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value="/eliminar", method=RequestMethod.GET)
	public String eliminar(@RequestParam("id") int idCategoria, 
			Model model, RedirectAttributes attributes) {
		categoriaService.eliminar(idCategoria);
		attributes.addFlashAttribute("msg2", "Categoria eliminada");
		return "redirect:/categorias/index";
	}
	
	@RequestMapping(value="/indexPaginate", method=RequestMethod.GET)
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria> lista = categoriaService.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {	
		List<Categoria> lista = categoriaService.obtenerTodas();
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	//@GetMapping("/crear")
	@RequestMapping(value="/crear",method=RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	//@PostMapping("/guardar")
	@RequestMapping(value="/guardar",method=RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
				}
			return "categorias/formCategoria";
			}
		
		System.out.println("Categoria : " + categoria);
		//guardar el objeto tipo vacante    
		//categoria.setId(categoriaService.obtenerTodas().size() + 1);
		attributes.addFlashAttribute("msg", "Registro guardado con exito!");
		//System.out.println("Numero de registros : " + categoriaService.obtenerTodas().size());
		categoriaService.guardar(categoria);
		return "redirect:/categorias/index";
	}
}
