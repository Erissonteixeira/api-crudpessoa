package io.github.Erissonteixeira.api_crudpessoa.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PersonRequestDTO {
    @NotBlank(message = "Person's name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;
    @PastOrPresent(message = "Date of birth must be in the past or today")
    private LocalDate birthDate;
    @NotBlank(message = "CPF is required")
    @Size(min = 11, max = 11, message = "CPF must be exactly 11 characters")
    @Pattern(regexp = "\\d{11}", message = "CPF must contain exactly 11 digits")
    private String cpf;

    public String getName(){
        return name;
    }
    public LocalDate getBirthDate(){
            return birthDate;
    }
    public String getCpf(){
        return cpf;
    }



}
