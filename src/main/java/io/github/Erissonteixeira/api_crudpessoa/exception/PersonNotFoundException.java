package io.github.Erissonteixeira.api_crudpessoa.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Pessoa não encontrada com id: " + id);
    }
}