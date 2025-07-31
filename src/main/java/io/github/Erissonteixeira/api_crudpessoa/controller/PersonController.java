package io.github.Erissonteixeira.api_crudpessoa.controller;

import io.github.Erissonteixeira.api_crudpessoa.model.Person;
import io.github.Erissonteixeira.api_crudpessoa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        var savePerson = service.savePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePerson);
    }
    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        var people = service.findAll();
        return ResponseEntity.ok(people);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deletarPerson(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person){
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePerson(id, person));
    }
}
