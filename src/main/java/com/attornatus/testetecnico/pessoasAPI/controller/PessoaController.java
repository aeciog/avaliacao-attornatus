package com.attornatus.testetecnico.pessoasAPI.controller;


import com.attornatus.testetecnico.pessoasAPI.dto.request.EnderecoDTO;
import com.attornatus.testetecnico.pessoasAPI.dto.response.MensagemResponseDTO;
import com.attornatus.testetecnico.pessoasAPI.dto.request.PessoaDTO;
import com.attornatus.testetecnico.pessoasAPI.entity.Endereco;
import com.attornatus.testetecnico.pessoasAPI.entity.Pessoa;
import com.attornatus.testetecnico.pessoasAPI.exception.PessoaNotFoundException;
import com.attornatus.testetecnico.pessoasAPI.service.EnderecoService;
import com.attornatus.testetecnico.pessoasAPI.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {

    private PessoaService pessoaService;
    private EnderecoService enderecoService;

    @Autowired
    public PessoaController(PessoaService pessoaService, EnderecoService enderecoService) {
        this.pessoaService = pessoaService;
        this.enderecoService = enderecoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemResponseDTO criarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.criarPessoa(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarTodos(){
        return pessoaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity< Pessoa > getPessoaById(@PathVariable long id) throws PessoaNotFoundException {
        return ResponseEntity.ok().body(pessoaService.getPessoaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity < Pessoa > updatePessoa(@PathVariable long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        return ResponseEntity.ok().body(this.pessoaService.updatePessoa(pessoa));
    }

    // CAMADA DE ENDEREÇO


    @RequestMapping(value = "/pessoas/{id}/endereco", method = RequestMethod.POST)

    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok().body(this.enderecoService.criarEndereco(endereco));
    }


    @RequestMapping(value = "/pessoas/{id}/endereco", method = RequestMethod.GET)

    public ResponseEntity< Endereco > getEnderecoById(@PathVariable long id) throws PessoaNotFoundException {
        return ResponseEntity.ok().body((Endereco) enderecoService.getEnderecoById(id));
    }


     @RequestMapping(value = "/pessoas/{id}/endereco/{idEndereco}", method = RequestMethod.GET)
    public ResponseEntity< Endereco > getPrincipalEnd(@PathVariable long id) throws PessoaNotFoundException {
        return ResponseEntity.ok().body(enderecoService.getPrincipalEnd(id));
    }




}

