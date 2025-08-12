package io.github.Erissonteixeira.api_crudpessoa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Person's name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    @Column(name = "name_person", length = 100, nullable = false)
    private String nome;
    @PastOrPresent(message = "Date of birth must be in the past or today")
    @Column(name = "birth_date")
    private LocalDate dataNascimento;
    @NotBlank(message = "CPF is required")
    @Size(min = 11, max = 11, message = "CPF must be exactly 11 characters")
    @Pattern(regexp = "\\d{11}", message = "CPF must contain exactly 11 characters")
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Address> addresses = new ArrayList<>();

    public Person(){
    }
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
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

