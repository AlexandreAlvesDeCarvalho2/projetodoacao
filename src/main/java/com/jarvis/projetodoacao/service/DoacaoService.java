package com.jarvis.projetodoacao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jarvis.projetodoacao.model.Doacao;
import com.jarvis.projetodoacao.model.Usuario;
import com.jarvis.projetodoacao.repository.DoacaoRepository;
import com.jarvis.projetodoacao.repository.UsuarioRepository;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Doacao validaInsertDoacao(Doacao doacao) throws Exception{
        
        Optional<Usuario> usuario = usuarioRepository.findById(doacao.getIdUsuario());
        if(!usuario.isEmpty()){
            
        return doacaoRepository.save(doacao);
        } else {
            throw new Exception("Usuario não existe");
        }
    }

    public ResponseEntity<Doacao> validaUpdateDoacao(Doacao doacao, Long id) {

        return doacaoRepository.findById(id)
                .map(record -> {
                    record.setDtAgendamento(doacao.getDtAgendamento());
                    record.setEndereco(doacao.getEndereco());
                    record.setQntSangue(doacao.getQntSangue());
                    record.setSentimento(doacao.getSentimento());
                    Doacao updated = doacaoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<?> validaDeleteDoacao(Long id){

        return doacaoRepository.findById(id)
                .map(record -> {
                    doacaoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
