package com.vinicius.helpdesk.services;

import java.util.Optional; 
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.helpdesk.domain.Tecnico;
import com.vinicius.helpdesk.domain.dtos.TecnicoDTO;
import com.vinicius.helpdesk.repositories.TecnicoRepository;
import com.vinicius.helpdesk.services.exceptions.ObjectNotFoundExeption;


@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption("Objeto nao encontrado ID: " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {		
		objDTO.setId(null);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}

}