//CLASE CREADA POR JOAN SALAS 27/04
package com.ludoteca.arkham.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludoteca.arkham.excepciones.ExcepcionRecursoNoEncontrado;
import com.ludoteca.arkham.modelo.Expansion;
import com.ludoteca.arkham.modelo.Juego;
import com.ludoteca.arkham.modelo.Usuario;
import com.ludoteca.arkham.repositorio.ExpansionRepositorio;
import com.ludoteca.arkham.repositorio.JuegoRepositorio;
import com.ludoteca.arkham.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {

	@Autowired
	private UsuarioRepositorio repo;
	
	@Autowired
	private JuegoRepositorio juegoRepo;

	//Obtener los juegos en base a la id de un solo usuario
	//En caso de que no se haya realizado el login, no mostrar juegos
	@GetMapping("/juegosUsuario/{id}")
	public List<Juego> listarJuegosPorUsuario(@PathVariable Integer id) {
		Usuario usuario = repo.findById(id).orElseThrow(() -> new ExcepcionRecursoNoEncontrado("No existe usuario con el ID: "+id));
		List<Juego> listaSinFiltrar = juegoRepo.findAll();
		List<Juego> listaFiltrada = juegoRepo.findAll();
		listaFiltrada.clear();
		for(int i = 0; i < listaSinFiltrar.size();i++) {
			Juego juego= listaSinFiltrar.get(i);
			if(juego.getIdUsuario()==id) {
				listaFiltrada.add(juego);
			}
		}
		return listaFiltrada;
	}
	
	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return repo.save(usuario);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> obtenerJuegoPorId(@PathVariable Integer id){
		//En caso de que el juego no exista mandamos la excepcion creada
		Usuario usuario= repo.findById(id).orElseThrow(() -> new ExcepcionRecursoNoEncontrado("No existe usuario con el ID: "+id));
		return ResponseEntity.ok(usuario);
	}
}


