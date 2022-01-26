package com.vinicius.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.helpdesk.domain.Chamado;
import com.vinicius.helpdesk.domain.Cliente;
import com.vinicius.helpdesk.domain.Tecnico;
import com.vinicius.helpdesk.domain.enums.Perfil;
import com.vinicius.helpdesk.domain.enums.Prioridade;
import com.vinicius.helpdesk.domain.enums.Status;
import com.vinicius.helpdesk.repositories.ChamadoRepository;
import com.vinicius.helpdesk.repositories.ClienteRepository;
import com.vinicius.helpdesk.repositories.TecnicoRepository;

@Service
public class DBServices {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
		
	
	
	public void instaciaDB() {
		Tecnico tec1 = new Tecnico(null, "Vinicius Politta", "86779894044", "vini@teste.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Vinicius Santos", "67378545082", "vini2@teste.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Nayelen kretli", "17963915068", "nayteste@teste.com", "123");
		cli1.addPerfil(Perfil.CLIENTE);
		
		Cliente cli2 = new Cliente(null, "Melissa kretli", "33893165070", "melteste@teste.com", "123");
		cli1.addPerfil(Perfil.CLIENTE);
		
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2, cli2);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		clienteRepository.saveAll(Arrays.asList(cli2));
		
		chamadoRepository.saveAll(Arrays.asList(c1));
		chamadoRepository.saveAll(Arrays.asList(c2));
	}
}
