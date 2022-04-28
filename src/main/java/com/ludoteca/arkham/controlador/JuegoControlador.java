//CLASE CREADA POR JOAN SALAS 27/04
package com.ludoteca.arkham.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludoteca.arkham.excepciones.ExcepcionRecursoNoEncontrado;
import com.ludoteca.arkham.modelo.Juego;
import com.ludoteca.arkham.repositorio.JuegoRepositorio;

@RestController
//Para entrar a todas las rutas que hayan más abajo, estas deben tener antes la ruta especificada
@RequestMapping("/api/v1/")
//CrossOrigin nos permite intercambiar recursos entre backend y frontend
@CrossOrigin(origins = "http://localhost:4200")
public class JuegoControlador {

	@Autowired
	private JuegoRepositorio repo;

	// Metodo para recuperar todos los juegos de la BD (retorna en formato JSON)
	@GetMapping("/juegos")
	public List<Juego> listarJuegos() {
		return repo.findAll();
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
}


