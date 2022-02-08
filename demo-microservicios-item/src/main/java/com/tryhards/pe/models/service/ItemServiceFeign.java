package com.tryhards.pe.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tryhards.pe.clients.ProductoClienteRest;
import com.tryhards.pe.models.entity.Item;

@Service("serviceFeign")
//@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRest clientefeign;
	
	@Override
	public List<Item> findAll() { 
		return clientefeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) { 
		return new Item(clientefeign.detalle(id), cantidad);
	}

}
