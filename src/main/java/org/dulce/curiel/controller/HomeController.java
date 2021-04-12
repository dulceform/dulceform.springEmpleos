package org.dulce.curiel.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.dulce.curiel.model.Vacante;
import org.dulce.curiel.service.IntCategoriasService;
import org.dulce.curiel.service.IntVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
	
	@Autowired
	private IntCategoriasService categoriasService;
	
	@Autowired
	private IntVacantesService serviceVacantes;
	
	@GetMapping("/index")
	public String mostrarIndex(Authentication aut) {
		//logica para recuperar el nombre de usuario y hacer cualquier tipo de 
		//operacion
		return "redirect:/";
	}
	
	@GetMapping("/buscar")
	public String buscar(@ModelAttribute("search") Vacante vacante, Model model) {
		System.out.println("Buscar por " + vacante);
		Example<Vacante> example = Example.of(vacante);
		List<Vacante> lista = serviceVacantes.buscarByExample(example);
		model.addAttribute("vacante", vacante);
		return "index";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> vacantes = serviceVacantes.buscarDestacadas();
		model.addAttribute("vacantes", vacantes);
		return "index";
	}
	//################################
	@GetMapping("/mensaje")
	public String mensaje(Model model) {
		String msg ="Bienvenidos a Empleos App";
        //creamos un atributo para enviarlo a la vista
        LocalDate fecha = LocalDate.now();
        model.addAttribute("msg", msg);
        try {
            fecha =LocalDate.parse("08-02-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println("Fecha : " + fecha);
            model.addAttribute("fecha", java.sql.Date.valueOf(fecha));
        }catch(DateTimeException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return "index";
	}
	//####################################
	@GetMapping("/vacante")
	public String imprimirVacante(Model model) {
		String nombre= "Ingeniero electronico";
		LocalDate fecha = LocalDate.now();
		Double salario = 12500.0;
		Boolean vigente = true;
		//crear los atributos para enviarlos a la vista
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fecha);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		return "vacante";
	}
	//#######################################
	@GetMapping("/lista")
	public String Lista(Model model) {
		List<String> vacantes = new LinkedList<String>();
		vacantes.add("Contador") ;
		vacantes.add("Programador web");
		vacantes.add("Arquitecto");
		vacantes.add("Ingeniero Electricista");
		model.addAttribute("vacantes", vacantes);
		for(String vacante: vacantes) {
			System.out.println(vacante);
		}
		return "vacante";
	}
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	@GetMapping("/imprimir")
	public String mostrarVacante(Model model) {
		Vacante vacante = new Vacante();
		System.out.println(vacante);
		vacante.setId(1000);
		vacante.setNombre("Programador web");
		vacante.setDescripcion("Para desarrollar aplicaciones web con Spring");
		vacante.setFecha(LocalDate.now());
		vacante.setSalario(123000.00);
		System.out.println(vacante);
		model.addAttribute("vacante", vacante);
		return "vacante";
	}
	
	@GetMapping("/tabla")
	public String tabla(Model model) {
		List<Vacante> vacantes = serviceVacantes.obtenerTodas();
		for(Vacante vacante : vacantes) {
			System.out.println(vacante.getId());
			System.out.println(vacante.getNombre());
			System.out.println(vacante.getDescripcion());
			System.out.println(vacante.getFecha());
			System.out.println(vacante.getSalario());
			System.out.println(vacante.getDestacado());
		}
		model.addAttribute("vacantes", vacantes);
		return "tabla";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		Vacante vacanteSearch = new Vacante();
		vacanteSearch.reset();
		model.addAttribute("search", vacanteSearch);
		model.addAttribute("categorias", categoriasService.obtenerTodas());
	}
	
	/*
	 * InitBinder para String, si los detecta vacios en el dataBinding los pasa a null
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

}
