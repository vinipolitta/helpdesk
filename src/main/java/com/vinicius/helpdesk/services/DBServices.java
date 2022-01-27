package com.vinicius.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instaciaDB() {
		Tecnico tec1 = new Tecnico(null, "Vinicius Politta", "86779894044", "vini@teste.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Vinicius Santos", "67378545082", "vini2@teste.com", encoder.encode("123"));

		Tecnico tec3 = new Tecnico(null, "Vinicius TESTE", "61842655043", "viniTeste@teste.com", encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "Nayelen kretli", "17963915068", "nayteste@teste.com", encoder.encode("123"));

		Cliente cli2 = new Cliente(null, "Melissa kretli", "33893165070", "melteste@teste.com", encoder.encode("123"));

		Cliente cli3 = new Cliente(null, "Melissa TEste", "87393155095", "meltesteteste@teste.com",
				encoder.encode("123"));

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2, cli2);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		tecnicoRepository.saveAll(Arrays.asList(tec3));

		clienteRepository.saveAll(Arrays.asList(cli1));
		clienteRepository.saveAll(Arrays.asList(cli2));
		clienteRepository.saveAll(Arrays.asList(cli3));

		chamadoRepository.saveAll(Arrays.asList(c1));
		chamadoRepository.saveAll(Arrays.asList(c2));
	}
}
