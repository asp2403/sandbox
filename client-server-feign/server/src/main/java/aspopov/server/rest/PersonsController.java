package aspopov.server.rest;

import aspopov.api.dto.PersonDto;
import aspopov.api.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {
    private final PersonService personService;

    public PersonsController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/server/persons")
    List<PersonDto> getPersons() {
        var persons = personService.getPersons();
        return persons;
    }
}
