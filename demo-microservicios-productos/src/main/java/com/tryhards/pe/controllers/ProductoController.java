package com.tryhards.pe.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tryhards.pe.models.entity.Producto;
import com.tryhards.pe.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment environment;
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	private IProductoService productoservice;

	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoservice.findAll().stream().map(p -> {
			//p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			p.setPort(port);
			return p;
		}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoservice.findById(id);
		//producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//		boolean ok = false;
//		if(!ok) { 
//			throw new RuntimeException("no se pudo cargar el producto");
//		}
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto.setPort(port);
		return producto;

	}
}
