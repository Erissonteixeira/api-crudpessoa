package io.github.Erissonteixeira.api_crudpessoa.repository;

import io.github.Erissonteixeira.api_crudpessoa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
