package com.jarvis.projetodoacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.projetodoacao.model.Doacao;
import com.jarvis.projetodoacao.repository.DoacaoRepository;
import com.jarvis.projetodoacao.service.DoacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Question")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoacaoController {

    @Autowired
    DoacaoRepository doacaoRepository;

    @Autowired
    DoacaoService doacaoService;


    @ApiOperation(value = "Buscar todas doacoes do pelo id do usuario")
    @GetMapping(value = "/doacoes/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Doacao> buscarDoacaoPorId(@PathVariable("id") Long id) {
        return doacaoRepository.findByIdUsuario(id);
    }

    @ApiOperation(value = "Inserir doacao")
    @PostMapping(value = "/doacoes")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Doacao createDoacao(@RequestBody Doacao doacao) throws Exception {
        return doacaoService.validaInsertDoacao(doacao);
    }

    @ApiOperation(value = "Alterar doacao")
    @PutMapping(value = "/doacoes/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Doacao> update(@PathVariable("id") Long id,
            @RequestBody Doacao doacao) {
        return doacaoService.validaUpdateDoacao(doacao, id);
    }

    @ApiOperation(value = "Deletar doacao")
    @DeleteMapping(path = { "/doacoes/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return doacaoService.validaDeleteDoacao(id);
    }
}
