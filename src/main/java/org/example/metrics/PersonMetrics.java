package org.example.metrics;

import lombok.RequiredArgsConstructor;
import org.example.repository.PersonRepository;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMetrics implements InfoContributor {

    private final PersonRepository personRepository;

    @Override
    public void contribute(Info.Builder builder) {
        var countPersons = personRepository.count();
        builder.withDetail("countPersons", countPersons);
    }
}
