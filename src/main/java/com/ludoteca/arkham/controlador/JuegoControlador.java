//CLASE CREADA POR JOAN SALAS 27/04
package com.ludoteca.arkham.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludoteca.arkham.modelo.Juego;
import com.ludoteca.arkham.repositorio.JuegoRepositorio;

@RestController
//Para entrar a todas las rutas que hayan más abajo, estas deben tener antes la ruta especificada
@RequestMapping("/api/v1/")
public class JuegoControlador {

	@Autowired
	private JuegoRepositorio repo;

	// Metodo para recuperar todos los juegos de la BD
	@GetMapping("/juegos")
	public List<Juego> listarJuegos() {
		return repo.findAll();
	}
}
