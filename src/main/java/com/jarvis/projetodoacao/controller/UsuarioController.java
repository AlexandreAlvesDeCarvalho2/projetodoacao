package com.jarvis.projetodoacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jarvis.projetodoacao.model.Usuario;
import com.jarvis.projetodoacao.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Question")
public class UsuarioController {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    UsuarioRepository usuarioRepository;
  
    @ApiOperation(value = "Buscar todos os Usuarios")
    @GetMapping(value="/usuarios")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Usuario> findUsuario(){
        return usuarioRepository.findAll();
    }

    @ApiOperation(value = "Buscar usuario por id")
    @GetMapping(value = "/usuarios/{id}")
	public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id){
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return ResponseEntity.ok().body(obj);
	}
        
    @ApiOperation(value = "Inserir novo usuario")
    @PostMapping(value ="/usuarios")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    @ApiOperation(value = "Atualizar dados do usuario")
    @PutMapping(value="/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") long id,
                                          @RequestBody Usuario contact){
      return usuarioRepository.findById(id)
          .map(record -> {
              record.setNome(contact.getNome());
              record.setEmail(contact.getEmail());
              record.setSenha(contact.getSenha());
              record.setCpf(contact.getCpf());
              record.setGenero(contact.getGenero());
              record.setAltura(contact.getAltura());        
              record.setPeso(contact.getPeso());
              record.setEstadoCivil(contact.getEstadoCivil());
              record.setTpSanguineo(contact.getTpSanguineo());
              record.setDtNascimento(contact.getDtNascimento());
              Usuario updated = usuarioRepository.save(record);
              return ResponseEntity.ok().body(updated);
          }).orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Deletar usuario")
    @DeleteMapping(path ={"usuarios/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return usuarioRepository.findById(id)
            .map(record -> {
                usuarioRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }       
}