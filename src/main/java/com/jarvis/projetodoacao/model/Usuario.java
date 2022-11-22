package com.jarvis.projetodoacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "TB_USUARIO")
@Entity(name = "TB_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id_usuario")
    @Column(name = "id_usuario")
    private Long idUsuario;

    @JsonProperty(value = "nome")
    @Column(name = "nome", length = 50)
    private String nome;
    
    @Email    
    @JsonProperty(value = "email")
    @Column(name = "email", length = 50)
    private String email;

    @JsonProperty(value = "senha")
    @Column(name = "senha", length = 50)
    private String senha;

    @CPF
    @JsonProperty(value = "cpf")
    @Column(name = "cpf", length = 50)
    private String cpf;
    
    @JsonProperty(value = "genero")
    @Column(name = "genero", length = 50)
    private String genero;

    @JsonProperty(value = "altura")
    @Column(name = "altura", length = 50)
    private String altura;

    @JsonProperty(value = "estado_civil")
    @Column(name = "estado_civil", length = 50)
    private String estadoCivil;

    @JsonProperty(value = "tp_sanguineo")
    @Column(name = "tp_sanguineo", length = 50)
    private String tpSanguineo;

    @JsonProperty(value = "data_nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Calendar dtNascimento;

}