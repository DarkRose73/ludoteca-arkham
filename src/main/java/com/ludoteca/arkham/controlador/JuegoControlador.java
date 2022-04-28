//CLASE CREADA POR JOAN SALAS 27/04
package com.ludoteca.arkham.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
