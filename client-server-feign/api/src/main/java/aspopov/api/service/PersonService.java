package aspopov.api.service;

import aspopov.api.dto.PersonDto;

import java.util.List;

public interface PersonService {
    List<PersonDto> getPersons();
}
