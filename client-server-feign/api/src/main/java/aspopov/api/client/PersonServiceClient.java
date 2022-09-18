package aspopov.api.client;

import aspopov.api.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "person-service", url = "${feign.url}")
public interface PersonServiceClient {
    @GetMapping("/server/persons")
    List<PersonDto> getPersons();
}
