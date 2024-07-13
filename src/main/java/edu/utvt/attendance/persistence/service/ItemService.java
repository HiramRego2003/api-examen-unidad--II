package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.repositories.ItemRepository;

public interface ItemService {
	

	public Item save(Item item);

	public Item update(Long id, Item item);

	public  List<Item> findAll();

	public Optional<Item> findById(Long id);

	public void deleteById(Long id);


}
