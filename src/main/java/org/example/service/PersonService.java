package org.example.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
@Getter
public class PersonService {
    private Map<Long, Person> personMap = new HashMap<>();

    private long ids;

    public void save(Person person) {
        long personId = Optional.ofNullable(person.getId()).orElseGet(() -> ids++);
        person.setId(personId);
        personMap.put(personId, person);
    }
}
