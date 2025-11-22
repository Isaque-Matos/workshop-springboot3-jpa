package com.isaquematos.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isaquematos.course.entities.User;
import com.isaquematos.course.services.UserService;

@RestController //Cria controladores, indica que a classe contém métodos que vão responder com dados diretamente (JSON ou XML)
@RequestMapping(value = "/users") // anotação usada para mapear requisições HTTP para métodos específicos
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping //indica que o método vai tratar requisições GET, ou seja, obter dados de um servidor
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")//indica q a requisição aceita um id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri(); //criando um uri
		return ResponseEntity.created(uri).body(obj); //fazendo com que aconteça o 201 created no postman, que é a forma adequada
		//de se inserir um recurso no banco de dados
	}
}
