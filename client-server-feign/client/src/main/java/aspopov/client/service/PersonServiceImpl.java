package aspopov.client.service;

import aspopov.api.dto.PersonDto;
import aspopov.api.contract.PersonServiceContract;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements aspopov.client.service.PersonService {
    private final PersonServiceContract personServiceClient;

    public PersonServiceImpl(PersonServiceContract personServiceClient) {
        this.personServiceClient = personServiceClient;
    }

    @Override
    public List<PersonDto> getPersons() {
        return personServiceClient.getPersons();
    }
}
