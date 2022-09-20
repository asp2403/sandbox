package aspopov.librarydatajdbc.service.converter;

import aspopov.librarydatajdbc.domain.Author;
import org.springframework.stereotype.Component;


@Component
public class AuthorConverterImpl implements AuthorConverter {
    @Override
    public String convertToString(Author author) {
        return author.getId() + ": " + author.getName();
    }
}
