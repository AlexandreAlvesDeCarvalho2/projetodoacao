package com.jarvis.projetodoacao.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "TB_DOACAO")
public class Doacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_Doacao")
    private Long idDoacao;

    @JsonProperty(value = "data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Calendar dtAgendamento;

    @JsonProperty(value = "clinica")
    @Column(name = "clinica", length = 50, nullable = false)
    private String endereco;

    @JsonProperty(value="qnt_sangue")
    @Column(name = "qnt_sangue", length = 50, nullable = false)
    private String qntSangue;

    
    @JsonProperty(value="sentimento")
    @Column(name = "sentimento", length = 50, nullable = false)
    private String sentimento;

     // ==================== relações ======================
    @JsonProperty(value = "id_usuario")
    @Column(name = "id_usuario", length = 50, nullable = false)
    private Long idUsuario;
}