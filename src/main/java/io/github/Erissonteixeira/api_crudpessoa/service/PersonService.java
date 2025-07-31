package io.github.Erissonteixeira.api_crudpessoa.service;

import io.github.Erissonteixeira.api_crudpessoa.model.Address;
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
    public Person findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + id));
    }
        public  Person updatePerson(Long id, Person novaPessoa){
        Person person = findById(id);
        person.setNome(novaPessoa.getNome());
        person.setDataNascimento(novaPessoa.getDataNascimento());
        person.setCpf(novaPessoa.getCpf());
        person.getAddresses().clear();
        for (Address endereco : novaPessoa.getAddresses()){
            endereco.setPerson(person);
            person.getAddresses().add(endereco);
        }
        return repository.save(person);
    }
    public void deletarPerson(Long id){
        repository.deleteById(id);
    }
}
