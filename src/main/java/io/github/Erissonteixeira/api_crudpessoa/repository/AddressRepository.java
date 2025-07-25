package io.github.Erissonteixeira.api_crudpessoa.repository;

import io.github.Erissonteixeira.api_crudpessoa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
