package com.isaquematos.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaquematos.course.entities.User;

@RestController //Cria controladores, indica que a classe contém métodos que vão responder com dados diretamente (JSON ou XML)
@RequestMapping(value = "/users") // anotação usada para mapear requisições HTTP para métodos específicos
public class UserResource {

	@GetMapping //indica que o método vai tratar requisições GET, ou seja, obter dados de um servidor
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
