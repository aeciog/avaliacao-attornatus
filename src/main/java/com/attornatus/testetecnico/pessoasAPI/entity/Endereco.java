package com.attornatus.testetecnico.pessoasAPI.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data // Insere automaticamente os Getters e Setters
@Builder // Padrão de construção de Objetos
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Será gerado automaticamente pelo banco de dados.
    private Long id;
    private String longradouro;
    private String cep;
    private int numero;
    private String cidade;

}