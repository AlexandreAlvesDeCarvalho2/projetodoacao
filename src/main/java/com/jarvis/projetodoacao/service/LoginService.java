package com.jarvis.projetodoacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.projetodoacao.repository.UsuarioRepository;

@Service
public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public String validarLogin(String email, String senha){
        if(email.isEmpty() && senha.isEmpty()){
            return "Usuario não existe";
        } else {
            usuarioRepository.findByEmailAndSenha(email, senha);
            return "Usuario existente.";            
        }
    }
    
}
