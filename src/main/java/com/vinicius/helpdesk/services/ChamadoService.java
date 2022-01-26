package com.vinicius.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.helpdesk.domain.Chamado;
import com.vinicius.helpdesk.repositories.ChamadoRepository;
import com.vinicius.helpdesk.services.exceptions.ObjectNotFoundExeption;

@Service
public class ChamadoService {

	
	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption("Objeto nao encontrado! ID:  " + id));
	}
}
