package com.isaquematos.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaquematos.course.entities.Order;
import com.isaquematos.course.services.OrderService;

@RestController //Cria controladores, indica que a classe contém métodos que vão responder com dados diretamente (JSON ou XML)
@RequestMapping(value = "/orders") // anotação usada para mapear requisições HTTP para métodos específicos
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping //indica que o método vai tratar requisições GET, ou seja, obter dados de um servidor
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")//indica q a requisição aceita um id dentro da url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
