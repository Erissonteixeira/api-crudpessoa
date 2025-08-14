package io.github.Erissonteixeira.api_crudpessoa.controller;

import io.github.Erissonteixeira.api_crudpessoa.dto.PersonRequestDTO;
import io.github.Erissonteixeira.api_crudpessoa.dto.PersonResponseDTO;
import io.github.Erissonteixeira.api_crudpessoa.model.Person;
import io.github.Erissonteixeira.api_crudpessoa.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<PersonResponseDTO> save(@RequestBody @Valid PersonRequestDTO dto){
        PersonResponseDTO savedPerson = service.createPerson(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }
    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> findAll(){
        List<PersonResponseDTO> people = service.findAll();
        return ResponseEntity.ok(people);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deletePerson(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable Long id, @RequestBody @Valid PersonRequestDTO dto){
        return ResponseEntity.ok(service.updatePerson(id, dto));
    }
}
