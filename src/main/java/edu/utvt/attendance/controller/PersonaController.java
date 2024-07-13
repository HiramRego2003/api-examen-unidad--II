package edu.utvt.attendance.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.service.PersonaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/v1/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;

	@GetMapping("/all")
	public List<Persona> get() {
		return this.personaService.findAll();
	}

	@PostMapping
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		return ResponseEntity.created(null).body(this.personaService.save(persona));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Persona> update(@PathVariable("id") UUID id, @RequestBody Persona persona) {
		return ResponseEntity.ok(this.personaService.update(id, persona));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> findById(@PathVariable("id") UUID id) {
		return ResponseEntity.of(this.personaService.findById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {

		this.personaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
