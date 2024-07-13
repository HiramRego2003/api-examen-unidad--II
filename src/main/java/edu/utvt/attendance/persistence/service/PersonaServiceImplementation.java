package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.repositories.PersonaRepository;

@Service
@Transactional
public class PersonaServiceImplementation implements PersonaService{
	
	@Autowired
	private PersonaRepository repository;

	@Transactional(readOnly = false)
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		this.repository.save(persona);
		return persona;
	}

	

@Transactional(readOnly = false)
	public Persona update(UUID id, Persona persona) {
	Optional<Persona> optionalPersona = null;
	optionalPersona = this.repository.findById(id);
	
	if (optionalPersona.isPresent()) {
		optionalPersona.get().setNombre(persona.getNombre());
		optionalPersona.get().setEdad(persona.getEdad());
		optionalPersona.get().setUniversidad(persona.getUniversidad());
		optionalPersona.get().setEmail(persona.getEmail());
		optionalPersona.get().setBirthDate(persona.getBirthDate());
		
		this.repository.save(optionalPersona.get());
	}
	
	return optionalPersona.orElseThrow();
	}

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Optional<Persona> findById(UUID id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

	@Override
	public void deleteById(UUID id) {
		this.repository.deleteById(id);
		
	}

	
	
	

}
