package aspopov.server.service;

import aspopov.api.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private static final List<PersonDto> PERSONS = List.of(new PersonDto("Vasya Pupkin", "vasya@mail.ru"), new PersonDto("Petya Batareikin", "petya@mail.ru"));
    @Override
    public List<PersonDto> getPersons() {
        return PERSONS;
    }
}
