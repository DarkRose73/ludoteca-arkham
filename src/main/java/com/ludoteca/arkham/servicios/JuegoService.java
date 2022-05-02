//Autor: Joan Salas 02/05/2022
package com.ludoteca.arkham.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ludoteca.arkham.repositorio.JuegoRepositorio;

@Service
public class JuegoService{

	@Autowired
	private JuegoRepositorio repo;
}
