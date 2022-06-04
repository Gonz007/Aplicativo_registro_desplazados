package com.sg.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.presentation.model.Grafico;
import com.sg.presentation.repository.GraficoRepo;
import com.sg.presentation.service.SequenceGeneratorService;

import net.guides.springboot.crud.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class GraficoController {
	@Autowired
	private GraficoRepo GraficoRepo;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/grafico")
	public List<Grafico> getAllGrafico() {
		return GraficoRepo.findAll();
	}

	@GetMapping("/grafico/{id}")
	public ResponseEntity<Grafico> getEmployeeById(@PathVariable(value = "id") Long graficoId)
			throws ResourceNotFoundException {
		Grafico employee = GraficoRepo.findById(graficoId)
				.orElseThrow(() -> new ResourceNotFoundException("" + graficoId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/grafico")
	public Grafico createEmployee(@Valid @RequestBody Grafico grafico) {
		grafico.setId(sequenceGeneratorService.generateSequence(Grafico.SEQUENCE_NAME));
		return GraficoRepo.save(grafico);
	}

	@PutMapping("/grafico/{id}")
	public ResponseEntity<Grafico> updateEmployee(@PathVariable(value = "id") Long graficoId,
			@Valid @RequestBody Grafico graficoDetails) throws ResourceNotFoundException {
		Grafico grafico = GraficoRepo.findById(graficoId)
				.orElseThrow(() -> new ResourceNotFoundException("" + graficoId));

		
		grafico.setName(graficoDetails.getName());
		grafico.setDatos(graficoDetails.getDatos());
		
		final Grafico updatedGrafico = GraficoRepo.save(grafico);
		return ResponseEntity.ok(updatedGrafico);
		
	}

	@DeleteMapping("/grafico/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long graficoId)
			throws ResourceNotFoundException {
		Grafico grafico = GraficoRepo.findById(graficoId)
				.orElseThrow(() -> new ResourceNotFoundException("" + graficoId));

		GraficoRepo.delete(grafico);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}