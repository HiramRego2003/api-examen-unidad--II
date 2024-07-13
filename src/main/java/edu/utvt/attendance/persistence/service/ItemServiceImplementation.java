package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.repositories.ItemRepository;

@Service
@Transactional
public class ItemServiceImplementation implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional(readOnly = false)
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return this.itemRepository.save(item);
	}

	@Transactional(readOnly = false)
	@Override
	public Item update(Long id, Item item) {
		// TODO Auto-generated method stub
		Optional<Item> optionalItem = null;
		optionalItem = this.findById(id);
		
		
		if (optionalItem.isPresent()) {
			optionalItem.get().setNombre(item.getNombre());
			optionalItem.get().setPrecio(item.getPrecio());
			this.itemRepository.save(optionalItem.get());
		}
		
		return optionalItem.orElseThrow();
	}


	@Override
	public Optional<Item> findById(Long id) {
		// TODO Auto-generated method stub
		return this.itemRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		this.itemRepository.deleteById(id);

	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return this.itemRepository.findAll();
	}

}
