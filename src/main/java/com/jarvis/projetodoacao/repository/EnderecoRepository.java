package com.jarvis.projetodoacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.projetodoacao.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
    List<Endereco> findByIdUsuario(Long idUsuario);
}

