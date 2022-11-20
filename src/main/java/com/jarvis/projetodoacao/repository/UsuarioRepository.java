package com.jarvis.projetodoacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarvis.projetodoacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query(nativeQuery = true, value= "select * from tb_usuario where email= :email and senha= :senha")
    public Usuario findByEmailAndSenha(@Param("email") String email,@Param("senha") String senha);

    public Usuario save(Optional<Usuario> entity);

    List<Usuario> findByEmail(String email);


}


