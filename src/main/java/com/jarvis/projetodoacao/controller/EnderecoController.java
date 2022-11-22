package com.jarvis.projetodoacao.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jarvis.projetodoacao.model.Endereco;
import com.jarvis.projetodoacao.repository.EnderecoRepository;
import com.jarvis.projetodoacao.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Question")
public class EnderecoController {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EnderecoService enderecoService;

    // @ApiOperation(value = "Buscar todos os enderecos")
    // @GetMapping(value = "/enderecos")
    // @ResponseStatus(code = HttpStatus.OK)
    // public List<Endereco> findUsuario() {
    //     return enderecoRepository.findAll();
    // }

    @ApiOperation(value = "Buscar endereco por id")
    @GetMapping(value = "/enderecos/{id}")
    public ResponseEntity<Optional<Endereco>> findById(@PathVariable Long id) {
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Inserir novo endereco")
    @PostMapping(value = "/enderecos")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Endereco createUsuario(@RequestBody Endereco endereco) throws Exception {
        return enderecoService.validaInsertEndereco(endereco);
    }

    @ApiOperation(value = "Atualizar dados do endereco")
    @PutMapping(value = "/enderecos/{id}")
    public ResponseEntity<Endereco> update(@PathVariable("id") long id,
            @RequestBody Endereco contact) {
        return enderecoRepository.findById(id)
                .map(record -> {
                    record.setCep(contact.getCep());
                    record.setBairro(contact.getBairro());
                    record.setCidade(contact.getCidade());
                    record.setComplemento(contact.getComplemento());
                    record.setIdDoacao(contact.getIdDoacao());
                    record.setLogradouro(contact.getLogradouro());
                    record.setEstado(contact.getBairro());
                    record.setIdUsuario(contact.getIdUsuario());
                    Endereco updated = enderecoRepository.saveAndFlush(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
