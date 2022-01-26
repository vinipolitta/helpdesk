package com.vinicius.helpdesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.helpdesk.domain.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}
