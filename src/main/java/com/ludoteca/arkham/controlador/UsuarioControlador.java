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
import com.ludoteca.arkham.modelo.Juego;
import com.ludoteca.arkham.repositorio.JuegoRepositorio;
import com.ludoteca.arkham.servicios.JuegoService;

//RestController nos define un controlador de tipo REST
@RestController
//Para entrar a todas las rutas que hayan más abajo, estas deben tener antes la ruta especificada
@RequestMapping("/api/v1/")
//CrossOrigin nos permite intercambiar recursos entre backend y frontend
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {

	@GetMapping("/")
	public String login() {
		return "Login exitoso";
	}
}
