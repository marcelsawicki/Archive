package departament.repository;

import org.springframework.data.repository.CrudRepository;

import departament.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {}
