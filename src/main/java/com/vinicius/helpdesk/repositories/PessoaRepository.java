package com.vinicius.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.helpdesk.domain.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
