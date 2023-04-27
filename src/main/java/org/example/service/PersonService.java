package org.example.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
@Getter
public class PersonService {
//    private Map<Long, Person> personMap = new HashMap<>();
//
//    private long ids;
//
//    public void save(Person person) {
//        long personId = Optional.ofNullable(person.getId()).orElseGet(() -> ids++);
//        person.setId(personId);
//        personMap.put(personId, person);
//    }

    @Autowired
    private PersonRepository personRepository;

    public void save(Person person) {
        personRepository.save(person);
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public void deleteAllPersons() {
        personRepository.deleteAll();
    }
}
