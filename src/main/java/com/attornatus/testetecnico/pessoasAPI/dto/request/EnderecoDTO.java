package com.attornatus.testetecnico.pessoasAPI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Insere automaticamente os Getters e Setters
@Builder // Padrão de construção de Objetos
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String longradouro;
    private String cep;
    private int numero;
    private String cidade;

}
