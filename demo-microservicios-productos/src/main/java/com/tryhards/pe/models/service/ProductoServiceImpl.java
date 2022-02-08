package com.tryhards.pe.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tryhards.pe.models.dao.ProductoDAO;
import com.tryhards.pe.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductoDAO productodao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) { 
		return productodao.findById(id).orElseThrow(IllegalArgumentException::new);
	}

}
