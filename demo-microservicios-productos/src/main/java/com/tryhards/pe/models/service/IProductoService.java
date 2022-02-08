package com.tryhards.pe.models.service;

import java.util.List;

import com.tryhards.pe.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findById(Long id); 
}
