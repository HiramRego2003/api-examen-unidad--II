package edu.utvt.attendance.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	List<Item> findByNombre(String nombre);


}
