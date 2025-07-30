package io.github.Erissonteixeira.api_crudpessoa.service;

import io.github.Erissonteixeira.api_crudpessoa.model.Person;
import io.github.Erissonteixeira.api_crudpessoa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person savePerson(Person person){
       return repository.save(person);
    }
    public List<Person> findAll(){
        return repository.findAll();
    }
}
