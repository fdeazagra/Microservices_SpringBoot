package com.fdeazagra.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fdeazagra.springboot.app.item.models.Item;
import com.fdeazagra.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceFeign")//Para elegir el componente que queremos usar si hay más de uno
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}

}
