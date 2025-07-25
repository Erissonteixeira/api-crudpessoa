package io.github.Erissonteixeira.api_crudpessoa.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private String nome;
    private LocalDate dataNascimento;
    private final String cpf;

    public Person(Long id, String nome, LocalDate dataNascimento, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
}

