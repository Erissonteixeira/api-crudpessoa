package io.github.Erissonteixeira.api_crudpessoa.dto;

import io.github.Erissonteixeira.api_crudpessoa.model.Person;

import java.time.LocalDate;
import java.time.Period;

public class PersonResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private int age;

    public PersonResponseDTO(Person person){
        this.id = person.getId();
        this.name = person.getNome();
        this.cpf = person.getCpf();
        this.birthDate = person.getDataNascimento();
        this.age = calculateAge(person.getDataNascimento());
    }
    private int calculateAge(LocalDate birthDate){
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCpf(){
        return cpf;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public int getAge(){
        return age;
    }
}
