package com.attornatus.testetecnico.pessoasAPI.dto.request;

import com.attornatus.testetecnico.pessoasAPI.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PessoaDTO{
    private long id;
    private String nome;
    private String dataNascimento;
    private List<Endereco> endereco;
}
