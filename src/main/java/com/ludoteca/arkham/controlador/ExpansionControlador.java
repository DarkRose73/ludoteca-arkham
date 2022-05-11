package com.ludoteca.arkham.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ludoteca.arkham.excepciones.ExcepcionRecursoNoEncontrado;
import com.ludoteca.arkham.modelo.Expansion;
import com.ludoteca.arkham.repositorio.ExpansionRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

//Autor: Joan Salas 03/05
public class ExpansionControlador {

	@Autowired
	private ExpansionRepositorio repo;

	//Recuperar todas las expansiones
	@GetMapping("/expansiones")
	public List<Expansion> listarExpansiones() {
		return repo.findAll();
	}
	//Agregar una expansion
	@PostMapping("/expansiones")
	public Expansion guardarExpansion(@RequestBody Expansion expansion) {
		return repo.save(expansion);
	}

	//Obtener expansion por ID
	@GetMapping("/expansiones/{id}")
	public ResponseEntity<Expansion> obtenerExpansionPorId(@PathVariable Integer id) {
		Expansion expansion = repo.findById(id)
				.orElseThrow(() -> new ExcepcionRecursoNoEncontrado("No existe la expansion con el ID: " + id));
		return ResponseEntity.ok(expansion);
	}

	@DeleteMapping("/expansiones/{id}")
	public void eliminarExpansion(@PathVariable Integer id) {
		repo.deleteById(id);
	}
}
