package org.dulce.curiel.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.dulce.curiel.model.Categoria;
import org.dulce.curiel.model.Vacante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImp implements IntVacantesService{
	//atributo de tipo LinkedList
	private List<Vacante> lista = null;
	
	//metodo constructor
	public VacantesServiceImp() {
		// TODO Auto-generated method stub
		lista = new LinkedList<Vacante>();
		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Arquitecto");
			v1.setDescripcion("Relacionado con la construccion");
			v1.setFecha(LocalDate.parse("12-01-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v1.setSalario(9500.0);
			v1.setDestacado(1);
			v1.setEstatus("Aprovada");
			v1.setImagen("arquitecto.jpg");
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Construccion");
			c1.setDescripcion("Relacionado con actividades referentes a construir");
			v1.setCategoria(c1);
			lista.add(v1);
			//#################################
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Contador");
			v2.setDescripcion("Para llevar la contabilidad general");
			v2.setFecha(LocalDate.parse("20-01-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v2.setSalario(8500.0);
			v2.setDestacado(0);
			v2.setEstatus("Eliminada");
			v2.setImagen("contador.jpg");
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Contabilidad");
			c2.setDescripcion("Relacionado con actividades de contador");
			v2.setCategoria(c2);
			lista.add(v2);
			//#################################
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Tecnico de Mantenimiento");
			v3.setDescripcion("Para soporte a equipos de computo");
			v3.setFecha(LocalDate.parse("02-02-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v3.setSalario(5500.0);
			v3.setDestacado(1);
			v3.setEstatus("Aprovada");
			v3.setImagen("ingeniero.jpg");
			Categoria c3 = new Categoria();
			c3.setId(2);
			c3.setNombre("Informatica");
			c3.setDescripcion("Relacionado con actividades con computadoras");
			v3.setCategoria(c3);
			lista.add(v3);
			//#################################
			Vacante v4 = new Vacante();
			v4.setId(4);
			v4.setNombre("Ingeniero Electronico");
			v4.setDescripcion("Para desarrollo de aplicaciones IOT");
			v4.setFecha(LocalDate.parse("08-02-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v4.setSalario(14500.0);
			v4.setDestacado(0);
			v4.setEstatus("Eliminada");
			v4.setImagen("programador.jpg");
			Categoria c4 = new Categoria();
			c4.setId(2);
			c4.setNombre("Informatica");
			c4.setDescripcion("Relacionado con actividades con computadoras");
			v4.setCategoria(c4);
			lista.add(v4);
			//#################################
			Vacante v5 = new Vacante();
			v5.setId(5);
			v5.setNombre("Maestro");
			v5.setDescripcion("Para impartir conocimientos");
			v5.setFecha(LocalDate.parse("08-02-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v5.setSalario(14500.0);
			v5.setDestacado(0);
			v5.setEstatus("Eliminada");
			v5.setImagen("programador.jpg");
			Categoria c5 = new Categoria();
			c5.setId(2);
			c5.setNombre("Educacion");
			c5.setDescripcion("Relacionado con actividades educativas");
			v5.setCategoria(c5);
			lista.add(v5);
			
			
		}catch(DateTimeParseException ex){
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		for(Vacante vacante : obtenerTodas()) {
			if(vacante.getId() == idVacante) {
				return vacante;
			}
		}
		return null;
	}

	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
	}

	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

}
