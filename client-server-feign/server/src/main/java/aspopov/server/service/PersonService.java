package aspopov.server.service;



import java.util.List;
import aspopov.api.dto.PersonDto;

public interface PersonService {
    List<PersonDto> getPersons();
}
