//INTERFAZ CREADA POR JOAN SALAS 27/04
package com.ludoteca.arkham.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ludoteca.arkham.modelo.Juego;

@Repository
//JpaRepository<Entidad, tipoDeID>
public interface JuegoRepositorio extends JpaRepository<Juego, Integer>{

	
}
