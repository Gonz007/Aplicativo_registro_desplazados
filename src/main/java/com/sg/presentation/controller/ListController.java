package com.sg.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.sg.presentation.model.Donacion;
import com.sg.presentation.repository.RepoList;

@RestController
@CrossOrigin(origins = "x", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})

@RequestMapping("/api/Donacion")
public class ListController {

	
	@Autowired
	private RepoList repository;
	
	@GetMapping("/")
	public List<Donacion> readAll(){
		return repository.findAll();
	}
	@PostMapping("/Donacion")
	public Donacion create(@Validated @RequestBody Donacion p) {
		return repository.insert(p);
	}
	
	
	
	
	@PutMapping("/Donacion/{id}")
	public Donacion update (@PathVariable String id, @Validated @RequestBody Donacion p) {
		return repository.save(p);
	}
	
	@DeleteMapping("/Donacion/{id}")
	public void  delete(@PathVariable String id) {
		repository.deleteById(id);
		
	}
	
}
