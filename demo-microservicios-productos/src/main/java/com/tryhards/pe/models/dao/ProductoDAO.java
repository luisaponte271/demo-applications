package com.tryhards.pe.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.tryhards.pe.models.entity.Producto;

public interface ProductoDAO extends CrudRepository<Producto, Long> {

}
