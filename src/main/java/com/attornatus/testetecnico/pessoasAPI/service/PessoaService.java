package com.attornatus.testetecnico.pessoasAPI.service;

import com.attornatus.testetecnico.pessoasAPI.dto.response.MensagemResponseDTO;
import com.attornatus.testetecnico.pessoasAPI.entity.Pessoa;
import com.attornatus.testetecnico.pessoasAPI.exception.PessoaNotFoundException;
import com.attornatus.testetecnico.pessoasAPI.repository.EnderecoRepository;
import com.attornatus.testetecnico.pessoasAPI.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;

    }


    public MensagemResponseDTO criarPessoa(Pessoa pessoaDTO){
        Pessoa salvarPessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .dataNascimento(pessoaDTO.getDataNascimento())
                .endereco(pessoaDTO.getEndereco())
                .build();

        Pessoa pessoaSalva = pessoaRepository.save(salvarPessoa);
        return MensagemResponseDTO
                .builder()
                .messagem("Pessoa criada com o ID " + pessoaSalva.getId())
                .build();
    }


    public List<Pessoa> listarTodos() {

        return this.pessoaRepository.findAll();
        //Manipular e transformar dados em coleções

    }

    public Pessoa getPessoaById(long id) {

        Optional < Pessoa > optionalPessoa = this.pessoaRepository.findById(id);

        if (optionalPessoa.isPresent()) {
            return optionalPessoa.get();
        }
        else {
        throw new PessoaNotFoundException(id);
        }
    }


    public Pessoa updatePessoa(Pessoa pessoa) {
        Optional < Pessoa > optionalPessoa = this.pessoaRepository.findById(pessoa.getId());

        if (optionalPessoa.isPresent()) {
            Pessoa pessoaUpdate = optionalPessoa.get();
            pessoaUpdate.setId(pessoa.getId());
            pessoaUpdate.setNome(pessoa.getNome());
            pessoaUpdate.setDataNascimento(pessoa.getDataNascimento());
            pessoaUpdate.setEndereco(pessoa.getEndereco());
            pessoaRepository.save(pessoaUpdate);
            return pessoaUpdate;
        } else {
            throw new PessoaNotFoundException(pessoa.getId());
        }
    }


}
