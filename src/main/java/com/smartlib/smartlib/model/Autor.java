package com.smartlib.smartlib.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // IDENTITY
    private Long id;

    @OneToOne(mappedBy = "autor")
    @JsonBackReference
    private Livro livro;

    @CreationTimestamp
    @Column(name = "registradoEm", nullable = false, updatable = false)
    private LocalDateTime registradoEm;

    @UpdateTimestamp
    @Column(name = "editadoEm", nullable = false)
    private LocalDateTime editadoEm;

    @Column(unique = true, nullable = false)
    private String nome;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
