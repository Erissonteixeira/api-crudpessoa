package io.github.Erissonteixeira.api_crudpessoa.service;

import io.github.Erissonteixeira.api_crudpessoa.dto.PersonRequestDTO;
import io.github.Erissonteixeira.api_crudpessoa.dto.PersonResponseDTO;
import io.github.Erissonteixeira.api_crudpessoa.model.Person;
import io.github.Erissonteixeira.api_crudpessoa.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.Erissonteixeira.api_crudpessoa.exception.PersonNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository repository;
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public PersonResponseDTO createPerson(PersonRequestDTO dto){
        Person person = new Person();
        person.setNome(dto.getName());
        person.setDataNascimento(dto.getBirthDate());
        person.setCpf(dto.getCpf());

        Person savedPerson = repository.save(person);
        return new PersonResponseDTO(savedPerson);
    }
    @Transactional(readOnly = true)
    public List<PersonResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(PersonResponseDTO::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public PersonResponseDTO findById(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return new PersonResponseDTO(person);
    }

    @Transactional
    public PersonResponseDTO updatePerson(Long id, PersonRequestDTO dto) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        person.setNome(dto.getName());
        person.setDataNascimento(dto.getBirthDate());
        person.setCpf(dto.getCpf());

        // se você quiser atualizar endereços, precisaria adaptar para receber DTOs de Address
        person.getAddresses().clear();

        Person updatedPerson = repository.save(person);
        return new PersonResponseDTO(updatedPerson);
    }

    @Transactional
    public void deletePerson(Long id) {
        if (!repository.existsById(id)) {
            throw new PersonNotFoundException(id);
        }
        repository.deleteById(id);
    }
}


