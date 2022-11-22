package com.jarvis.projetodoacao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.projetodoacao.model.Endereco;
import com.jarvis.projetodoacao.model.Usuario;
import com.jarvis.projetodoacao.repository.EnderecoRepository;
import com.jarvis.projetodoacao.repository.UsuarioRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public Endereco validaInsertEndereco(Endereco endereco) throws Exception{
        
        Optional<Usuario> usuario = usuarioRepository.findById(endereco.getIdUsuario());
        if(!usuario.isEmpty()){
            
        return enderecoRepository.save(endereco);
        } else {
            throw new Exception("Endereco não existe");
        }
    }
    
}
