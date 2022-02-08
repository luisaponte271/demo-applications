package com.tryhards.pe.models.service;

import java.util.List;

import com.tryhards.pe.models.entity.Item;

public interface ItemService {
	
	public List<Item> findAll(); 
	public Item findById(Long id, Integer cantidad);
}
