package com.attornatus.testetecnico.pessoasAPI.service;

import com.attornatus.testetecnico.pessoasAPI.entity.Endereco;
import com.attornatus.testetecnico.pessoasAPI.exception.PessoaNotFoundException;
import com.attornatus.testetecnico.pessoasAPI.repository.EnderecoRepository;;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class EnderecoService{
    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Object getEnderecoById(long id) {
        Optional< Endereco > optionalEndereco = this.enderecoRepository.findById(id);

        if (optionalEndereco.isPresent()) {
            return optionalEndereco.get();
        }
        else {
            throw new PessoaNotFoundException(id);
        }
    }

    public Endereco getPrincipalEnd(long id) {

        Optional < Endereco > optionalEndPrin = this.enderecoRepository.findById(id);

        if (optionalEndPrin.isPresent()) {
            return optionalEndPrin.get();
        }
        else {
            throw new PessoaNotFoundException(id);
        }
    }


}
