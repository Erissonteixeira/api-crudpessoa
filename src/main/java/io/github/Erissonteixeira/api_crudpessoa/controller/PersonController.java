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
}
