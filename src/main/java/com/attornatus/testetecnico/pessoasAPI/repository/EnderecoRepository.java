package com.attornatus.testetecnico.pessoasAPI.repository;

import com.attornatus.testetecnico.pessoasAPI.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, Long> {
}
