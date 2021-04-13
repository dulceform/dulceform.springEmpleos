package org.dulce.curiel.service;

import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.dulce.curiel.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImp implements IntCategoriasService{
	//atributo de tipo LinkedList
	private List<Categoria> lista = null;
	
	//metodo constructor
	public CategoriasServiceImp() {
		// TODO Auto-generated method stub
		lista = new LinkedList<Categoria>();
		try {
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Educacion");
			c1.setDescripcion("Relacionado con la imparticion de conocimientos");
			lista.add(c1);
			//#################################
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Ventas");
			c2.setDescripcion("Relacionado con vender productos");
			lista.add(c2);
			//#################################
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Contabilidad");
			c3.setDescripcion("Relacionado con actividades de cuentas de dinero");
			lista.add(c3);
			//#################################
			Categoria c4 = new Categoria();
			c4.setId(4);
			c4.setNombre("Construccion");
			c4.setDescripcion("Relacionado con la creacion de nuevas construcciones");
			lista.add(c4);
			//#################################
			Categoria c5 = new Categoria();
			c5.setId(5);
			c5.setNombre("Informatica");
			c5.setDescripcion("Relacionado con computacion y sistemas");
			lista.add(c5);
			
		}catch(DateTimeParseException ex){
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		for(Categoria categoria : obtenerTodas()) {
			if(categoria.getId() == idCategoria) {
				return categoria;
			}
		}
		return null;
	}

	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		lista.add(categoria);
	}

	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
