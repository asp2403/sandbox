package aspopov.librarydatajdbc.service.converter;

import aspopov.librarydatajdbc.domain.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreConverterImpl implements GenreConverter {
    @Override
    public String convertToString(Genre genre) {
        return genre.getId() + ": " + genre.getName();
    }
}
