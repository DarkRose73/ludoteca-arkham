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
import com.ludoteca.arkham.repositorio.ExpansionRepositorio;
import com.ludoteca.arkham.repositorio.JuegoRepositorio;

//RestController nos define un controlador de tipo REST
@RestController
//Para entrar a todas las rutas que hayan más abajo, estas deben tener antes la ruta especificada
@RequestMapping("/api/v1/")
//CrossOrigin nos permite intercambiar recursos entre backend y frontend
@CrossOrigin(origins = "http://localhost:4200")
public class JuegoControlador {

	@Autowired
	private JuegoRepositorio repo;
	
	@Autowired
	private ExpansionRepositorio expansionRepo;

	// Metodo para recuperar todos los juegos de la BD (retorna en formato JSON)
	@GetMapping("/juegos")
	public List<Juego> listarJuegos() {
		return repo.findAll();
	}
	
	//Metodo para recuperar las expansiones de un juego
	// 04/05
	@GetMapping("/expansionesjuego/{id}")
	public List<Expansion> listarExpansiones(@PathVariable Integer id){
		//Validar que exista el juego consultado
		Juego juego = repo.findById(id).orElseThrow(() -> new ExcepcionRecursoNoEncontrado("No existe el Juego con el ID: "+id));
		//Creacion de las listas de expansiones (una con todas las expansiones y una con filtro del id del juego)
		List<Expansion> listaSinFiltrar = expansionRepo.findAll();
		List<Expansion> listaFiltrada = expansionRepo.findAll();
		listaFiltrada.clear();
		//Se realiza el filtro
		for(int i = 0; i < listaSinFiltrar.size();i++) {
			Expansion exp = listaSinFiltrar.get(i);
			if(exp.getIdJuego()==id) {
				listaFiltrada.add(exp);
			}
		}
		return listaFiltrada;
	}
	
	//Joan Salas 28/04
	//Metodo para poder guardar un juego en la BD
	@PostMapping("/juegos")
	//RequestBody sirve para enviar el objeto en formato JSON
	public Juego guardarJuego(@RequestBody Juego juego) {
		return repo.save(juego);
	}
	
	//Metodo utilizado para buscar un juego por ID
	@GetMapping("/juegos/{id}")
	public ResponseEntity<Juego> obtenerJuegoPorId(@PathVariable Integer id){
		//En caso de que el juego no exista mandamos la excepcion creada
		Juego juego = repo.findById(id).orElseThrow(() -> new ExcepcionRecursoNoEncontrado("No existe el Juego con el ID: "+id));
		return ResponseEntity.ok(juego);
	}
	
	//Actualización de un juego
	@PutMapping("/juegos/{id}")
	public ResponseEntity<Juego> actualizarJuego(@PathVariable Integer id, @RequestBody Juego detalleJuego){
		//Buscar el juego por ID
		Juego juego = repo.findById(id).orElseThrow(() -> new ExcepcionRecursoNoEncontrado("No existe el Juego con el ID: "+id));

		//En caso de que exista, setear los nuevos valores
		juego.setNombre(detalleJuego.getNombre());
		juego.setPrecio(detalleJuego.getPrecio());
		juego.setEdicion(detalleJuego.getEdicion());
		
		//Crear un nuevo objeto de clase juego y guardarlo
		Juego juegoActualizado = repo.save(juego);
		return ResponseEntity.ok(juegoActualizado);
	}


	//Eliminación de un juego
	@DeleteMapping("/juegos/{id}")
	public void eliminarJuego(@PathVariable Integer id){
		repo.deleteById(id);
	}

}


