package aspopov.client.rest;

import aspopov.api.dto.PersonDto;
import aspopov.client.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/client/persons")
    public List<PersonDto> getPersons() {
        return personService.getPersons();

    }
}
