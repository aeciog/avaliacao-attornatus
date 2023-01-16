package com.attornatus.testetecnico.pessoasAPI.repository;


import com.attornatus.testetecnico.pessoasAPI.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {

}
