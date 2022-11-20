package com.jarvis.projetodoacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "TB_ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_endereco")
    private Long idDoacao;

    @Column(name = "cep", length = 50, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 50, nullable = false)
    private String logradouro;

    @Column(name = "complemento", length = 50, nullable = false)
    private String complemento;

    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;
    
}
