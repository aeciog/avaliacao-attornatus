package com.attornatus.testetecnico.pessoasAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException(Long id) {
        super("Pessoa não encontrada com id " + id);
    }
}
