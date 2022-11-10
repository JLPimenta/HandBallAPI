package br.com.handballCamp.data.service;

import br.com.handballCamp.data.model.Person;
import br.com.handballCamp.data.repository.PersonRepository;

public class CrudPersonService {

    private PersonRepository personRepository;

    public CrudPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private void Create() {
        // Aqui ficaria o(s) valor(es) recebido(s) do front pelo usuário 

        Person person = new Person(null, null, null, null);
        personRepository.save(person);
    }

    private void Read() {
        Iterable<Person> people = personRepository.findAll();

        people.forEach(person -> System.out.println(person)); // ou retornaria no front para o usuário
    }

    private void Update() {

    }

    private void Delete() {

    }
}
