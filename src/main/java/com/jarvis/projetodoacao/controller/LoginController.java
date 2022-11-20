package com.jarvis.projetodoacao.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.jarvis.projetodoacao.model.Doacao;
import com.jarvis.projetodoacao.model.Login;
import com.jarvis.projetodoacao.model.Usuario;
import com.jarvis.projetodoacao.repository.UsuarioRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {

    @Autowired
    UsuarioRepository usuarioreRepository;

    @ApiOperation(value = "Validacao de login")
    @PostMapping(value = "/login")
    @ResponseStatus(code = HttpStatus.OK)
    public Usuario buscarDoacaoPorEmaileSenha(@RequestBody Login login) throws Exception {

        String email = login.getEmail();
        String senha = login.getSenha();
        List<Usuario> usuarioList = usuarioreRepository.findByEmail(email);
        try {
            if (Objects.equals(usuarioList.get(0).getSenha(), senha)) {
                return usuarioList.get(0);
            }
        } catch (Exception e) {
            throw new Exception("Usuario ou senha inválida");
        }
        
        throw new Exception("Usuario ou senha inválida");
    }

}
