package com.disney.alkemy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.disney.alkemy.DAO.UsuarioDAO;
import com.disney.alkemy.model.Usuario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AlkemyApplicationTests {

	@Autowired
	private UsuarioDAO usuario;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void createUsuarioTest() {
		Usuario us = new Usuario();
		us.setUsername("AlkemyTest");
		us.setPassword(encoder.encode("DisneyTest"));
		us.setEmail("AlkemyTest@hotmail.com");
		Usuario retorno = usuario.save(us);

		assertTrue(retorno.getPassword().equals(us.getPassword()));
	
	}

}
