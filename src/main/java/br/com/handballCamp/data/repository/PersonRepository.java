package br.com.handballCamp.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.handballCamp.data.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    
}