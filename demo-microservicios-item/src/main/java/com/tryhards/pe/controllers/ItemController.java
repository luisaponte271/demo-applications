package com.tryhards.pe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tryhards.pe.models.entity.Item;
import com.tryhards.pe.models.entity.Producto;
import com.tryhards.pe.models.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	//@Qualifier("serviceRestTemplate")
	private ItemService itemservice;

	@GetMapping("/listar")
	public List<Item> listar() {
		return itemservice.findAll();
	}
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) { 
		return itemservice.findById(id, cantidad);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto(); 
		producto.setId(id);
		producto.setNombre("Camara Sony");
		producto.setPrecio(500.00);
		
		item.setCantidad(cantidad);
		item.setProducto(producto);
		return item; 
		
	}
}
