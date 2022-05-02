package com.ludoteca.arkham;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ludoteca.arkham.modelo.Usuario;
import com.ludoteca.arkham.repositorio.UsuarioRepositorio;

@SpringBootTest
class LudotecaArkhamBackendApplicationTests {

	@Autowired
	private UsuarioRepositorio repo;
	
/*	@Autowired
	private BCryptPasswordEncoder encoder;
*/	
	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(2);
		us.setCorreo("usuario2@gmail.com");
		us.setClave("1234");
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}
}
