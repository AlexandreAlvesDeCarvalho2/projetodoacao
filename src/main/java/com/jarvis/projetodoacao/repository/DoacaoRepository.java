package com.jarvis.projetodoacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.projetodoacao.model.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long>{

    List<Doacao> findByIdUsuario(Long idUsuario);
}