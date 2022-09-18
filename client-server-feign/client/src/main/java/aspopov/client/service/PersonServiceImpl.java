package aspopov.client.service;

import aspopov.api.dto.PersonDto;
import aspopov.api.client.PersonServiceClient;
import aspopov.api.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonServiceClient personServiceClient;

    public PersonServiceImpl(PersonServiceClient personServiceClient) {
        this.personServiceClient = personServiceClient;
    }

    @Override
    public List<PersonDto> getPersons() {
        return personServiceClient.getPersons();
    }
}
